package iti.jets.jetshop;

import iti.jets.jetshop.Persistence.Entities.Category;
import iti.jets.jetshop.Persistence.EntityFactory;
import jakarta.persistence.EntityManager;


public class Test {
    public static void main(String[] args) {
        EntityManager obj = EntityFactory.getInstance().createEntityManager();


        Category cat = new Category();

        cat.setCategoryName("test");
        obj.getTransaction().begin();
        obj.persist(cat);
        obj.getTransaction().commit();
        obj.close();

    }
}
