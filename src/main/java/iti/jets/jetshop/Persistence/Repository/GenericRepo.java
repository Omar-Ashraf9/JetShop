package iti.jets.jetshop.Persistence.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class  GenericRepo <T,ID extends Serializable> implements GenericRepoInt<T,ID> {
    protected Class<T> persistentClass;
    protected final EntityManager entityManager;

    public GenericRepo(Class<T> persistentClass, EntityManager entityManager){
        this.persistentClass = persistentClass;
        this.entityManager = entityManager ;
    }
    public Optional<List<T>> findAll() {
        return Optional.of(entityManager.createQuery( "from " + persistentClass.getName(), persistentClass )
                .getResultList());
    }

    public Optional<T> findById(ID id) {
        return Optional.of(entityManager.find(persistentClass,id));
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public Optional<T> update(T entity) {
        return Optional.of(entityManager.merge(entity));
    }

    public void deleteById(ID id) {
        Optional<T> entity = findById(id);
        delete(entity.get());
    }

    public Integer count() {
        Query query = entityManager.createQuery("SELECT COUNT(c) FROM " + persistentClass.getName() + " c");
        return ((Long) query.getSingleResult()).intValue();
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }
}
