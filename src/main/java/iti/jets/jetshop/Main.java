package iti.jets.jetshop;

import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CategoryRepo;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable(DB.doInTransaction(em -> {
            CategoryRepo customerRepo = new CategoryRepo(em);
            return customerRepo.getProductsByCategoryName("Female");
        })));
    }
}
