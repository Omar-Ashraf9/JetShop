package iti.jets.jetshop.Services;


import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;
import jakarta.servlet.ServletContext;


public class CustomerService {
    static void register(ServletContext sc){
        DB.doInTransaction(em -> {
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = new Customer();
            customerRepo.create(customer);
            return null;
        });
    }
}
