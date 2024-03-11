package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Customer;
import jakarta.persistence.EntityManager;

public class CustomerRepo extends GenericRepo<Customer,Integer>{
    public CustomerRepo(EntityManager entityManager) {super(Customer.class , entityManager);}
}
