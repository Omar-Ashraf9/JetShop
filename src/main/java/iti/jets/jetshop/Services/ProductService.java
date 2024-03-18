package iti.jets.jetshop.Services;

import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Models.Mappers.ProductMapper;
import iti.jets.jetshop.Models.Mappers.ProductMapperImpl;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Persistence.Repository.CategoryRepo;
import iti.jets.jetshop.Persistence.Repository.ProductRepo;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductService {
    public static List<ProductDto> getAllProducts() {
        return DB.doInTransaction(em -> {

            ProductRepo productRepo = new ProductRepo(em);
            ProductMapper productMapper= ProductMapper.INSTANCE;
            return productRepo.findAll()
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(productMapper::toDto)
                    .collect(Collectors.toList());
        });
    }

    static  Optional<Set<Product>> getProductsByCategory(String  categoryName){
        return DB.doInTransaction(em->{
            CategoryRepo categoryRepo = new CategoryRepo(em);
            return  categoryRepo.getProductsByCategoryName(categoryName);
        });
    }
    public static  Optional<ProductDto> getProductById(String productId){

        return DB.doInTransaction(em->{
            ProductRepo productRepo = new ProductRepo(em);
            return productRepo.findById(Integer.valueOf(productId)).map(ProductMapper.INSTANCE::toDto);
        });
    }
//    public static boolean isQuantityAvailable(Integer quantity ,ProductDto product){
//
//    }
}
