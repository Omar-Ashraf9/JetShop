package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Optional;
import java.util.Set;

public class CustomerRepo extends GenericRepo<Customer,Integer>{
    public CustomerRepo(EntityManager entityManager) {super(Customer.class , entityManager);}

    public Optional<Customer> getCustomerByEmail(String email){
        System.out.println(email);
        Query query = entityManager
                .createQuery("SELECT c FROM Customer c WHERE c.email = :email",Customer.class);
        query.setParameter("email",email);
        Customer customer = (Customer) query.getSingleResult();
        
        if(customer == null){
            System.out.println("mafesh");
            return Optional.empty();
        }
        System.out.println(customer);
        return Optional.of(customer);
    }
}
