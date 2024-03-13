package iti.jets.jetshop.Services;


import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;


public class CustomerService {
    static void register(){
        DB.doInTransactionWithoutResult(em -> {
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = new Customer();
            customerRepo.create(customer);
        });
    }

    static Optional<Customer> isEmailFound(String email){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customer = customerRepo.getCustomerByEmail(email);
            if(customer.isPresent())
                return  customer;
            else
                return Optional.empty();
        });

    }
    static Optional<Customer> isCustomerFound(Integer id){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customer = customerRepo.findById(id);
            if(customer.isPresent())
                return  customer;
            else
                return Optional.empty();
        });

    }
    static boolean login(String email,String password){
        return DB.doInTransaction(em -> {
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customer = isEmailFound(email);
            if(customer.isPresent()&&customer.get().getPassword().equals(password)){
                return true;
            }
            else{
                // this email is not found in the database
                return false;
            }
        });
    }
    static Optional<Customer> updateCustomerProfile(Customer newCustomer){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            return customerRepo.update(newCustomer);
        });
    }
}
