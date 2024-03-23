package iti.jets.jetshop.Persistence.Repository;

import iti.jets.jetshop.Persistence.Entities.Customer;
import iti.jets.jetshop.Persistence.Entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ProductRepo extends GenericRepo<Product,Integer>{
    public ProductRepo(EntityManager entityManager) {super(Product.class , entityManager);}


}
