package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Order;
import jakarta.persistence.EntityManager;

public class OrderRepo extends GenericRepo<Order,Integer>{
    public OrderRepo(EntityManager entityManager) {super(Order.class , entityManager);}

}
