package iti.jets.jetshop.Controllers.Listeners;

import com.zaxxer.hikari.HikariDataSource;
import iti.jets.jetshop.Utils.ThreadLocalPopulator;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.HashMap;
import java.util.Map;

public class EntityFactoryListener implements ServletContextListener {
    public static EntityManagerFactory instance;
    private EntityFactoryListener() {
    }

    private static EntityManagerFactory getInstance() {
        if (instance == null) {
            HikariDataSource dataSource = new HikariDataSource();
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jetshop");
            dataSource.setUsername("root");
            dataSource.setPassword("");
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setMaximumPoolSize(15);

            Map<String, Object> properties = new HashMap<>();
            properties.put("jakarta.persistence.nonJtaDataSource", dataSource);

            instance = Persistence.createEntityManagerFactory("shop", properties);
        }
        return instance;
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory emf =  EntityFactoryListener.getInstance();
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("EntityManagerFactory", emf);

    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        EntityManagerFactory emf = (EntityManagerFactory) sc.getAttribute("EntityManagerFactory");
        emf.close();
    }

}
