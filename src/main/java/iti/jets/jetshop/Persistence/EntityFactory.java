package iti.jets.jetshop.Persistence;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class EntityFactory {
    public static EntityManagerFactory instance;
    private EntityFactory() {
    }

    public static EntityManagerFactory getInstance() {
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

}
