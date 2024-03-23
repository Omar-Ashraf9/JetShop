package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.*;

import java.util.Optional;
import java.util.Set;

public class CustomerRepo extends GenericRepo<Customer,Integer>{
    public CustomerRepo(EntityManager entityManager) {super(Customer.class , entityManager);}

//    public Optional<Customer> getCustomerByEmail(String email){
//        System.out.println(email);
//        Query query = entityManager
//                .createQuery("SELECT c FROM Customer c WHERE c.email = :email",Customer.class);
//        query.setParameter("email",email);
//        Customer customer = (Customer) query.getSingleResult();
//        System.out.println("wb3deeeen");
//        if(customer == null){
//            System.out.println("mafesh");
//            return Optional.empty();
//        }
//        System.out.println(customer);
//        return Optional.of(customer);
//    }
public Optional<Customer> getCustomerByEmail(String email) {
    try {
        TypedQuery<Customer> query = entityManager.createQuery(
                "SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
        query.setParameter("email", email);
        Customer customer = query.getSingleResult();
        return Optional.of(customer);
    } catch (NoResultException e) {
        System.out.println("Customer with email " + email + " not found."); // Print for debugging
        return Optional.empty();
    }
}
}
