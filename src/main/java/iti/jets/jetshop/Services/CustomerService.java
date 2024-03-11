package iti.jets.jetshop.Services;


import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;
import iti.jets.jetshop.Utils.ThreadLocalPopulator;


public class CustomerService {


    // we open entity manager on every method on service
    static  void  register(){
        CustomerRepo customerRepo = new CustomerRepo();
        Customer customer = new Customer();
        customerRepo.create(customer,ThreadLocalPopulator.getEntityManager());
    }
}
