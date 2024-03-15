package iti.jets.jetshop.Services;

import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Persistence.Repository.CategoryRepo;
import iti.jets.jetshop.Persistence.Repository.ProductRepo;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProductService {
    public static Optional<List<Product>> getAllProducts(){
        return DB.doInTransaction(em->{
            ProductRepo productRepo = new ProductRepo(em);
            return productRepo.findAll();
        });
    }

    static  Optional<Set<Product>> getProductsByCategory(String  categoryName){
        return DB.doInTransaction(em->{
            CategoryRepo categoryRepo = new CategoryRepo(em);
            return  categoryRepo.getProductsByCategoryName(categoryName);
        });
    }
}
