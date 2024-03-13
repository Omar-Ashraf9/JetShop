package iti.jets.jetshop.Services;

import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.*;
import iti.jets.jetshop.Persistence.Repository.CartItemRepo;
import iti.jets.jetshop.Persistence.Repository.CartRepo;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CartService {
    static Optional<BigDecimal> getTotalAmount(Integer cartId){
        return DB.doInTransaction(em->{
            Optional<Set<CartItem>> cartItems = getCartItems(cartId);
            BigDecimal total = new BigDecimal("0.0");
            for(CartItem item : cartItems.get()){
                BigDecimal itemAmount = item.getAmount().multiply(new BigDecimal(item.getQuantity()));
                total = total.add(itemAmount);
            }
            return Optional.of(total);
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
            Optional<Cart> cart = getCartById(cartId);
            cart.get().setCartItems(new HashSet<>());
            CartRepo cartRepo = new CartRepo(em);
            cartRepo.update(cart.get());
        });
    }
    static boolean checkout(Integer cartId,Customer customer){
        return DB.doInTransaction(em->{
            BigDecimal total = getTotalAmount(cartId).get();
            if(customer.getCreditLimit().compareTo(total)<0){
                return false;
            }
            removeCartItems(cartId);
            customer.setCreditLimit(customer.getCreditLimit().subtract(total));
            return true;
        });
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
    static Cart getCartFromCustomerId(Integer customerId){
        return DB.doInTransaction(em->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = customerRepo.findById(customerId).get();
            return customer.getCart();
        });
    }
    static void minusCartItemFromCart(CartItem cartItem,Integer customerId){
        DB.doInTransactionWithoutResult(em->{
            Cart cart = getCartFromCustomerId(customerId);
            if(cartItem.getQuantity()==1){
                cart.getCartItems().remove(cartItem);
            }
            else {
                cartItem.setQuantity(cartItem.getQuantity()-1);
            }
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = customerRepo.findById(customerId).get();
        //    customer.setCreditLimit(customer.getCreditLimit().subtract(product.getProductPrice()));
        });
    }
    static Boolean addProductToCart(Product product,Integer customerId){
        return DB.doInTransaction(em->{
            if(product.getStockQuantity()==0) {
                return false;
            }
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = customerRepo.findById(customerId).get();
            BigDecimal price = new BigDecimal(String.valueOf(product.getProductPrice()));
//            if(customer.getCreditLimit().compareTo(price)<0){
//                return false;
//            }
            Cart cart = customer.getCart();
            CartItem cartItem ;

            if(isCartItemFound(cart.getId(), product.getId()).isPresent()){
                cartItem = isCartItemFound(cart.getId(), product.getId()).get();
                cartItem.setQuantity(cartItem.getQuantity()+1);
            }
            else{
                cartItem = new CartItem();
                cartItem.setCart(cart);
                cartItem.setProduct(product);
                cartItem.setAmount(product.getProductPrice());
                cartItem.setQuantity(1);
                cart.getCartItems().add(cartItem);
            }
            //customer.setCreditLimit(customer.getCreditLimit().subtract(price));
            return true;
        });
    }
    //remove product from cart
}
