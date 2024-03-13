package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.EntityManager;

import java.util.Optional;
import java.util.Set;

public class CustomerRepo extends GenericRepo<Customer,Integer>{
    public CustomerRepo(EntityManager entityManager) {super(Customer.class , entityManager);}

    public Optional<Customer> getCustomerByEmail(String email){
        Customer customer = entityManager
                .createQuery("SELECT c FROM Customer c WHERE c.email = email",Customer.class)
                .getSingleResult();
        if(customer == null){
            return Optional.empty();
        }
        return Optional.of(customer);
    }
}
