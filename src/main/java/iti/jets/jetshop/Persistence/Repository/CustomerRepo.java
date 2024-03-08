package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.EntityFactory;
import jakarta.persistence.EntityManager;

public class CustomerRepo extends GenericRepo<Customer,Integer>{
    private final static EntityManager entityManager;
    private static final ThreadLocal<EntityManager> entityManagerInstance = new ThreadLocal<>();

    static {
        entityManager = EntityFactory.getInstance().createEntityManager();
        entityManagerInstance.set(entityManager);
    }
    private static volatile CustomerRepo instance = null;
    private CustomerRepo() {
        super(Customer.class,entityManagerInstance.get());
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static EntityManager getCustomerEntityManager() {
        return entityManagerInstance.get();
    }
    public static CustomerRepo getInstance() {
        if (instance == null) {
            synchronized (CustomerRepo.class) {
                if (instance == null) {
                    instance = new CustomerRepo();
                }
            }
        }
        return instance;
    }
}
