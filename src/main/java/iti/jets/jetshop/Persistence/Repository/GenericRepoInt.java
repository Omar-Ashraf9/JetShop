package iti.jets.jetshop.Persistence.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface GenericRepoInt<T,ID>{
    public Optional<List<T>> findAll();
    public Optional<T> findById(ID id);
    public void create(T entity);
    public Optional<T> update(T entity);
    public void deleteById(ID id);
    public void delete(T entity);
}
