package iti.jets.jetshop.Persistence.Repository;

import java.util.List;

public interface GenericRepoInt<T,ID>{
    public List<T> findAll();
    public T findById(ID id);
    public void create(T entity);
    public T update(T entity);
    public void deleteById(ID id);
    public void delete(T entity);
}
