package iti.jets.jetshop;

import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Repository.CartRepo;
import iti.jets.jetshop.Persistence.Repository.CategoryRepo;
import iti.jets.jetshop.Persistence.Repository.CustomerRepo;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        Optional<BigDecimal>  total = DB.doInTransaction(em -> {
            CartRepo cartRepo = new CartRepo(em);
            return cartRepo.getTotalAmount(1);
        });

        if(total.isPresent())
            System.out.println(total.get());
        else
            System.out.println("Cart not found");
    }
}
