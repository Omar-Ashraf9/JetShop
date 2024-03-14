package iti.jets.jetshop.Services;


import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;

import java.util.Optional;


public class CustomerService {
    public static void register(){
        DB.doInTransactionWithoutResult(em -> {
            CustomerRepo customerRepo = new CustomerRepo(em);
            Customer customer = new Customer();
            customerRepo.create(customer);
        });
    }

    public static boolean isEmailFound(String email){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customer = customerRepo.getCustomerByEmail(email);
            if(customer.isPresent())
                return true;
            else
                return false;
        });
    }
//
//    public static Optional<Customer> isEmailFound(String email){
//        return DB.doInTransaction(em ->{
//            CustomerRepo customerRepo = new CustomerRepo(em);
//            Optional<Customer> customer = customerRepo.getCustomerByEmail(email);
//            if(customer.isPresent())
//                return customer;
//            else
//                return Optional.empty();
//        });
//    }
    public static Optional<Customer> isCustomerFound(Integer id){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            Optional<Customer> customer = customerRepo.findById(id);
            if(customer.isPresent())
                return  customer;
            else
                return Optional.empty();
        });

    }
    public static boolean login(String email,String password){
        if(isEmailFound(email))
        {
            return DB.doInTransaction(em -> {
                CustomerRepo customerRepo = new CustomerRepo(em);
                Optional<Customer> customer = customerRepo.getCustomerByEmail(email);
                if(customer.isPresent() && customer.get().getPassword().equals(password)){
                    return true;
                }
                else{
                    return false;
                }
            });
        } else
        {
            return false;
        }
    }
    public static Optional<Customer> updateCustomerProfile(Customer newCustomer){
        return DB.doInTransaction(em ->{
            CustomerRepo customerRepo = new CustomerRepo(em);
            return customerRepo.update(newCustomer);
        });
    }
}
