package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Cart;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Persistence.Entities.Category;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public class CartRepo extends GenericRepo<Cart,Integer>{
    public CartRepo(EntityManager entityManager) {super(Cart.class , entityManager);}

    public Optional<BigDecimal> getTotalAmount(Integer cartId){
        Cart cart = findById(cartId);
        if (cart == null) {
            return Optional.empty();
        }
        Set<CartItem> cartItems = cart.getCartItems();
        BigDecimal total = new BigDecimal("0.0");
        for(CartItem item : cartItems){
            BigDecimal itemAmount = item.getAmount().multiply(new BigDecimal(item.getQuantity()));
            total = total.add(itemAmount);
        }
        return Optional.of(total);
    }
}