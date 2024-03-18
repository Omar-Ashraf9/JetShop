package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.OrdersItem;
import iti.jets.jetshop.Persistence.Entities.OrdersItemId;
import jakarta.persistence.EntityManager;

public class OrderItemRepo extends GenericRepo<OrdersItem, OrdersItemId>{
    public OrderItemRepo(EntityManager entityManager) {super(OrdersItem.class , entityManager);}

}
