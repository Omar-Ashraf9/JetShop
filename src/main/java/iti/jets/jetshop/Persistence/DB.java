package iti.jets.jetshop.Persistence;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class DB {
    private static final EntityManagerFactory emf;

    static
    {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jetshop");
        dataSource.setUsername("root");
        dataSource.setPassword("");
//        dataSource.setJdbcUrl("jdbc:mysql://node592946-jetshop.j.layershift.co.uk:3306/jetshop");
//        dataSource.setUsername("root");
//        dataSource.setPassword("PQIpsp25969");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setMaximumPoolSize(15);

        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.nonJtaDataSource", dataSource);
        emf = Persistence.createEntityManagerFactory("shop", properties);
    }
    private DB() {}
    public static <R> R doInTransaction(Function<EntityManager, R> returningTransactionFunction)
    {
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            R result = returningTransactionFunction.apply(entityManager);
            transaction.commit();
            return result;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public static void doInTransactionWithoutResult(Consumer<EntityManager> voidTransactionFunction)
    {
        var entityManager = emf.createEntityManager();
        var transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            voidTransactionFunction.accept(entityManager);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    public static void close()
    {
        emf.close();
        System.out.println("Database resources cleaned up");
    }
}

//dataSource.setJdbcUrl("jdbc:mysql://node592946-jetshop.j.layershift.co.uk:3306/jetshop");
//        dataSource.setUsername("root");
//        dataSource.setPassword("PQIpsp25969");