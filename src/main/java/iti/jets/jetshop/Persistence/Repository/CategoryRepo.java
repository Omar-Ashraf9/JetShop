package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.EntityManager;

import java.util.Set;

public class CategoryRepo extends GenericRepo<Category,Integer>{
    public CategoryRepo(EntityManager entityManager) {super(Category.class , entityManager);}

    public Set<Product> getProductsByCategoryName(String categoryName){
        Category category = entityManager
                .createQuery("SELECT c FROM Category c WHERE c.categoryName = categoryName",Category.class)
                .getSingleResult();
        return category.getProducts();
    }
}
