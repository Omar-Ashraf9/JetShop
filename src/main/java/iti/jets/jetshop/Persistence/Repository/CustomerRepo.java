package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.EntityFactory;
import jakarta.persistence.EntityManager;

public class CustomerRepo extends GenericRepo<Customer, Integer>{
    private final static EntityManager entityManager;
    static {
        entityManager = EntityFactory.getInstance().createEntityManager();
    }
    public CustomerRepo() {
        super(Customer.class, entityManager);
    }
}
