package iti.jets.jetshop.Services;

import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Models.Mappers.ProductMapper;
import iti.jets.jetshop.Models.Mappers.ProductMapperImpl;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Persistence.Repository.CategoryRepo;
import iti.jets.jetshop.Persistence.Repository.ProductRepo;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class ProductService {
    public static Optional<List<ProductDto>> getAllProducts(){
        return DB.doInTransaction(em->{
            ProductRepo productRepo = new ProductRepo(em);
            ProductMapper productMapper = new ProductMapperImpl();
            productMapper.toDto()
            return productRepo.findAll();
        });
    }

    static  Optional<Set<Product>> getProductsByCategory(String  categoryName){
        return DB.doInTransaction(em->{
            CategoryRepo categoryRepo = new CategoryRepo(em);
            return  categoryRepo.getProductsByCategoryName(categoryName);
        });
    }    public static  Optional<Product> getProductById(String productId){
        return DB.doInTransaction(em->{
            ProductRepo productRepo = new ProductRepo(em);
            return  productRepo.findById(Integer.valueOf(productId));
        });
    }
}
