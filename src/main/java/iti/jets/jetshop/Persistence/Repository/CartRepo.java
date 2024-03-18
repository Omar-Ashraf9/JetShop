package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Cart;
import iti.jets.jetshop.Persistence.Entities.CartItem;
import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.Entities.OrdersItem;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

public class CartRepo extends GenericRepo<Cart,Integer>{
    public CartRepo(EntityManager entityManager) {super(Cart.class , entityManager);}

}
