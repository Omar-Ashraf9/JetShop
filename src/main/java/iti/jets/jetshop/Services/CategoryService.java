package iti.jets.jetshop.Services;

import iti.jets.jetshop.Models.DTO.CategoryDto;
import iti.jets.jetshop.Models.Mappers.CategoryMapper;
import iti.jets.jetshop.Models.Mappers.ProductMapper;
import iti.jets.jetshop.Persistence.DB;
import iti.jets.jetshop.Persistence.Entities.Product;
import iti.jets.jetshop.Persistence.Repository.CategoryRepo;
import iti.jets.jetshop.Persistence.Repository.ProductRepo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {

    public static List<CategoryDto> getAllCategories() {
        return DB.doInTransaction(em -> {
            CategoryRepo categoryRepo = new CategoryRepo(em);
            return categoryRepo.findAll()
                    .orElse(Collections.emptyList())
                    .stream()
                    .map(CategoryMapper.INSTANCE::toDto)
                    .collect(Collectors.toList());
        });
    }

    public static CategoryDto getCategoryById(Integer categoryId) {
        return DB.doInTransaction(em -> {
            CategoryRepo categoryRepo = new CategoryRepo(em);
            return categoryRepo.findById(categoryId)
                    .map(CategoryMapper.INSTANCE::toDto)
                    .orElse(null);
        });
    }
}
