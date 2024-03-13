package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Cart;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Persistence.Entities.CartItemId;
import jakarta.persistence.EntityManager;

public class CartItemRepo extends GenericRepo<CartItem, CartItemId>{
    public CartItemRepo(EntityManager entityManager) {super(CartItem.class , entityManager);}


}
