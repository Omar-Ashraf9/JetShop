package iti.jets.jetshop.Services;

import iti.jets.jetshop.Models.DTO.ProductDto;
import iti.jets.jetshop.Models.Mappers.CategoryMapper;
import iti.jets.jetshop.Models.Mappers.ProductMapper;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Persistence.Repository.CategoryRepo;
import iti.jets.jetshop.Persistence.Repository.ProductRepo;

import java.math.BigDecimal;
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

    public static  Optional<ProductDto> getProductById(String productId){

        return DB.doInTransaction(em->{
            ProductRepo productRepo = new ProductRepo(em);
            return productRepo.findById(Integer.valueOf(productId)).map(ProductMapper.INSTANCE::toDto);
        });
    }



    public static boolean isQuantityAvailable(Integer  productId){


        return DB.doInTransaction(em->{
            ProductRepo productRepo = new ProductRepo(em);
            Product product=productRepo.findById(productId).get();
            if(product.getStockQuantity()>=1){
                return true;
            }

            else
                return false;
        });

    }

    public static void addProduct(ProductDto productDto){
        DB.doInTransactionWithoutResult(em->{
            ProductRepo productRepo = new ProductRepo(em);
            Product product = new Product();

            product.setProductName(productDto.getProductName());
            product.setProductDescription(productDto.getProductDescription());
            product.setProductPrice(productDto.getProductPrice());
            product.setStockQuantity(productDto.getStockQuantity());
            product.setCategory(CategoryMapper.INSTANCE.toEntity(productDto.getCategory()));

            for (int i = 0; i < productDto.getProductImages().size(); i++) {
                product.addProductImage(productDto.getProductImages().get(i).getImageUrl());
            }
            productRepo.create(product);
        });
    }

    public static void updateProduct(ProductDto productDto){
        DB.doInTransactionWithoutResult(em->{
            ProductRepo productRepo = new ProductRepo(em);
            Product product = productRepo.findById(productDto.getId()).get();

            product.setProductName(productDto.getProductName());
            product.setProductDescription(productDto.getProductDescription());
            product.setProductPrice(productDto.getProductPrice());
            product.setStockQuantity(productDto.getStockQuantity());
            product.setCategory(CategoryMapper.INSTANCE.toEntity(productDto.getCategory()));

            for (int i = 0; i < productDto.getProductImages().size(); i++) {
                product.getProductImages().get(i).setImageUrl(productDto.getProductImages().get(i).getImageUrl());
            }
            productRepo.update(product);
        });
    }

    public static int getProductsCount() {
        return DB.doInTransaction(em -> {
            ProductRepo productRepo = new ProductRepo(em);
            return productRepo.count();
        });
    }

    public static List<ProductDto> getProductsFilteredWithPrice(BigDecimal minPrice,BigDecimal maxPrice){
        return DB.doInTransaction(em -> {
            ProductRepo productRepo = new ProductRepo(em);
            ProductMapper productMapper= ProductMapper.INSTANCE;
            return productRepo.findAll()
                    .orElse(Collections.emptyList())
                    .stream()
                    .filter(product -> {
                        BigDecimal productPrice = product.getProductPrice();
                        if (maxPrice.compareTo(BigDecimal.valueOf(-1)) == 0) {
                            return productPrice.compareTo(minPrice) >= 0;
                        } else {
                            return productPrice.compareTo(minPrice) >= 0 && productPrice.compareTo(maxPrice) <= 0;
                        }
                    })
                    .map(productMapper::toDto)
                    .collect(Collectors.toList());
        });
    }
    public static List<ProductDto> getProducts(int start,String category) {
        return DB.doInTransaction(em -> {

            ProductRepo productRepo = new ProductRepo(em);
            ProductMapper productMapper= ProductMapper.INSTANCE;
            return null;
        });
    }

}
