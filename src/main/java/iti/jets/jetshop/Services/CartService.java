package iti.jets.jetshop.Services;

import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.Mappers.CustomerMapper;
import iti.jets.jetshop.Models.Mappers.CustomerMapperImpl;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.*;
import iti.jets.jetshop.Persistence.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CartService {
    public static BigDecimal getTotalAmount(CustomerDto customerDto){
        return DB.doInTransaction(em->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
            Integer cartId = getCartFromCustomerId(customer.getId()).getId();
            Set<CartItem> cartItems = getCartItems(cartId).get();
            System.out.println("please "+ cartItems);
            BigDecimal total = new BigDecimal("0.0");
            for(CartItem item : cartItems){
                BigDecimal itemAmount = item.getAmount().multiply(new BigDecimal(item.getQuantity()));
                  total = total.add(itemAmount);
            }
            return total;
        });

    }
    static Optional<Set<CartItem>> getCartItems(Integer cartId){
        return DB.doInTransaction(em->{
            CartRepo cartRepo = new CartRepo(em);
            Optional<Cart> cart = getCartById(cartId);
            if (!cart.isPresent()) {
                return Optional.empty();
            }
            return Optional.of( cart.get().getCartItems());
        });
    }
    static Optional<Cart> getCartById(Integer cartId){
        return DB.doInTransaction(em-> {
            CartRepo cartRepo = new CartRepo(em);
            return  cartRepo.findById(cartId);
        });
    }
    static void removeCartItems(Integer cartId){
        DB.doInTransactionWithoutResult(em->{
            Query query = em.createQuery("DELETE  FROM CartItem c WHERE c.cart.id = :cartId");
            query.setParameter("cartId",cartId);
            query.executeUpdate();
        });
    }
    public static boolean checkout(CustomerDto customerDto){
        return DB.doInTransaction(em->{
            Customer customer = new CustomerRepo(em).getCustomerByEmail(customerDto.getEmail()).get();
            Integer cartId =getCartFromCustomerId(customer.getId()).getId();
            BigDecimal total = getTotalAmount(customerDto);
            if(customer.getCreditLimit().compareTo(total)<0){
                return false;
            }
            handleOrder(cartId,customer,em);
            removeCartItems(cartId);
            customer.setCreditLimit(customer.getCreditLimit().subtract(total));
            return true;
        });
    }
    private static void handleOrder(Integer cartId, Customer customer, EntityManager em){
        Cart cart = getCartById(cartId).get();
        Order order = new Order();
        order.setCustomer(customer);
        Instant orderedAt = Instant.now();
        order.setOrderedAt(orderedAt);
        OrderRepo orderRepo = new OrderRepo(em);

        for (CartItem cartItem:cart.getCartItems()){
            Product product = em.find(Product.class,cartItem.getProduct().getId());
            System.out.println(product.getProductName());
            order.addOrderItem(product,cartItem.getQuantity(),cartItem.getAmount());
        }
        orderRepo.create(order);

    }

    static Optional<CartItem> isCartItemFound(Integer cartId,Integer productId){
        return DB.doInTransaction(em->{
            CartItemRepo cartItemRepo = new CartItemRepo(em);
            CartItemId cartItemId = new CartItemId();
            cartItemId.setCartId(cartId);
            cartItemId.setProductId(productId);
            Optional<CartItem> cartItem = cartItemRepo.findById(cartItemId);
            if(cartItem.isPresent())
                return cartItem;
            else
                return Optional.empty();
        });
    }
    public static Cart getCartFromCustomerId(Integer customerId){
        return DB.doInTransaction(em->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            System.out.println(customerId+"########");
            Customer customer = customerRepo.findById(customerId).get();
            return customer.getCart();
        });
    }

    static void deductCartItemFromCart(CartItem cartItem, Integer customerId){
        DB.doInTransactionWithoutResult(em->{
            Cart cart = getCartFromCustomerId(customerId);
            if(cartItem.getQuantity()==1){
                cart.getCartItems().remove(cartItem);
            }
            else {
                cartItem.setQuantity(cartItem.getQuantity()-1);
            }
//            CustomerRepo customerRepo = new CustomerRepo(em);
//            Customer customer = customerRepo.findById(customerId).get();
        });
    }
    static Boolean addProductToCart(Product product,Integer customerId){
        return DB.doInTransaction(em->{
            if(product.getStockQuantity()==0) {
                return false;
            }
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = customerRepo.findById(customerId).get();

            Cart cart = customer.getCart();
            CartItem cartItem ;

            Optional<CartItem> cartItemOptional = isCartItemFound(cart.getId(), product.getId());
            if(cartItemOptional.isPresent()){
                cartItem = cartItemOptional.get();
                cartItem.setQuantity(cartItem.getQuantity() + 1);
            }
            else{
                cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setAmount(product.getProductPrice());
                cartItem.setQuantity(1);
                cart.getCartItems().add(cartItem);
            }
            return true;
        });
    }
    static void removeCartItemFromCart(CartItem cartItem, Integer customerId)
    {
        DB.doInTransactionWithoutResult(em -> {
            Cart cart = getCartFromCustomerId(customerId);
            cart.getCartItems().remove(cartItem);
        });
    }
}
