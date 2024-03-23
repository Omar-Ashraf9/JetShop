package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CategoryRepo extends GenericRepo<Category,Integer>{
    public CategoryRepo(EntityManager entityManager) {super(Category.class , entityManager);}
}
