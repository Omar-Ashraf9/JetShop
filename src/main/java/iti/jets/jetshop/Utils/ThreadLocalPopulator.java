package iti.jets.jetshop.Utils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletContext;

public class ThreadLocalPopulator {

    private static final ThreadLocal<EntityManager> ENTITY_MANAGER_CACHE = new ThreadLocal<>();

    public static void init(ServletContext context) {
        EntityManagerFactory emf = (EntityManagerFactory) context.getAttribute("EntityManagerFactory");
        ENTITY_MANAGER_CACHE.set(emf.createEntityManager());
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_CACHE.get();
    }

    public static void closeEntityManager() {
        ENTITY_MANAGER_CACHE.get().close();
        ENTITY_MANAGER_CACHE.remove();
    }

}