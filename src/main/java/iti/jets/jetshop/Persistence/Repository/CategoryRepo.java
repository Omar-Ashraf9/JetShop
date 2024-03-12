package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.EntityManager;

import java.util.Optional;
import java.util.Set;

public class CategoryRepo extends GenericRepo<Category,Integer>{
    public CategoryRepo(EntityManager entityManager) {super(Category.class , entityManager);}

    public Optional<Set<Product>> getProductsByCategoryName(String categoryName){
        Category category = entityManager
                .createQuery("SELECT c FROM Category c WHERE c.categoryName = categoryName",Category.class)
                .getSingleResult();
        if(category == null){
            return Optional.empty();
        }
        return Optional.of(category.getProducts());
    }
}
