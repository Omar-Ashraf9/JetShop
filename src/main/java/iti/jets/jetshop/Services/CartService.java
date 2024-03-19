package iti.jets.jetshop.Services;

import iti.jets.jetshop.Models.DTO.CartDto;
import iti.jets.jetshop.Models.DTO.CartItemDto;
import iti.jets.jetshop.Models.DTO.CustomerDto;
import iti.jets.jetshop.Models.Mappers.CartItemMapper;
import iti.jets.jetshop.Models.Mappers.CartMapper;
import iti.jets.jetshop.Models.Mappers.CustomerMapper;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.*;
import iti.jets.jetshop.Persistence.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.time.Instant;
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
    private static Optional<Set<CartItem>> getCartItems(Integer cartId){
        return DB.doInTransaction(em->{
            CartRepo cartRepo = new CartRepo(em);
            Optional<Cart> cart = getCartById(cartId);
            if (!cart.isPresent()) {
                return Optional.empty();
            }
            return Optional.of( cart.get().getCartItems());
        });
    }
    private static Optional<Cart> getCartById(Integer cartId){
        return DB.doInTransaction(em-> {
            CartRepo cartRepo = new CartRepo(em);
            return  cartRepo.findById(cartId);
        });
    }
    private static void removeCartItems(Integer cartId){
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
            Product product = new Product();
             product = em.find(Product.class,cartItem.getProduct().getId());
             product.setStockQuantity(product.getStockQuantity()-cartItem.getQuantity());
            order.addOrderItem(product,cartItem.getQuantity(),cartItem.getAmount());
        }
        orderRepo.create(order);
    }
    private static Optional<CartItem> isCartItemFound(Integer cartId,Integer productId){
        return DB.doInTransaction(em->{
            CartRepo cartRepo = new CartRepo(em);
            Cart cart = cartRepo.findById(cartId).get();
            boolean found = false;
            for(CartItem cartItem : cart.getCartItems()){
                if(cartItem.getProduct().getId()==productId){
                    found=true;
                    return Optional.of(cartItem);
                }
            }

            return Optional.empty();
        });
    }
    public static CartDto getCartFromCustomerId(Integer customerId){
        return DB.doInTransaction(em->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = customerRepo.findById(customerId).get();
            return CartMapper.INSTANCE.toDto(customer.getCart());
        });
    }

//    static void deductCartItemFromCart(CartItem cartItem, Integer customerId){
//        DB.doInTransactionWithoutResult(em->{
//            Cart cart = getCartFromCustomerId(customerId);
//            if(cartItem.getQuantity()==1){
//                cart.getCartItems().remove(cartItem);
//            }
//            else {
//                cartItem.setQuantity(cartItem.getQuantity()-1);
//            }
////            CustomerRepo customerRepo = new CustomerRepo(em);
////            Customer customer = customerRepo.findById(customerId).get();
//        });
//    }
    public static void addProductToCart(Integer productId,Integer customerId){
         DB.doInTransactionWithoutResult(em->{
            ProductRepo productRepo = new ProductRepo(em);
            Product product=productRepo.findById(productId).get();

            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = customerRepo.findById(customerId).get();

            Cart cart = customer.getCart();



            Optional<CartItem> cartItemOptional = isCartItemFound(cart.getId(), product.getId());
            if(cartItemOptional.isPresent()){
             CartItem cartItem = cartItemOptional.get();
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                CartItemRepo cartItemRepo = new CartItemRepo(em);
                cartItemRepo.update(cartItem);
            }
            else{

             System.out.println("product : " + product.getProductName());
                cart.addCartItem(product,1,product.getProductPrice());
             System.out.println("cart : "+cart.getId());
                CartRepo cartRepo = new CartRepo(em);
                cartRepo.update(cart);
            }

        });
    }
    static void removeCartItemFromCart(CartItem cartItem, Integer customerId)
    {
        DB.doInTransactionWithoutResult(em -> {
            CartDto cart = getCartFromCustomerId(customerId);
            cart.getCartItems().remove(cartItem);
        });
    }
    public static void createCart(CustomerDto customerDto){
         DB.doInTransactionWithoutResult(em->{
            Cart cart = new Cart();
            cart.setCustomer(CustomerMapper.INSTANCE.toEntity(customerDto));
            CartRepo cartRepo = new CartRepo(em);
            cartRepo.create(cart);
        });
    }

    public static void updateCartItemQuantity(CartItemDto cartItemDto, Integer quantity){
        DB.doInTransactionWithoutResult(em->{
            CartItemRepo cartItemRepo = new CartItemRepo(em);
            CartItem cartItem = CartItemMapper.INSTANCE.toEntity(cartItemDto);
            cartItem.setQuantity(quantity);
            cartItemRepo.update(cartItem);
        });
    }
}
