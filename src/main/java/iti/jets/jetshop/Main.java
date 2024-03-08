package iti.jets.jetshop;

import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;

public class Main {
    public static void main(String[] args) {
        CustomerRepo customerRepo = new CustomerRepo(Customer.class,Integer);
    }
}
