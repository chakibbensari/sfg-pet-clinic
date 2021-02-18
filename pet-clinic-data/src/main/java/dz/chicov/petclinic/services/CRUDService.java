package dz.chicov.petclinic.services;

import java.util.Set;

public interface CRUDService<T, I> {

    T findById(I id);
    Set<T> findAll();
    T save(T t);
    void delete(T t);
    void deleteById(I id);
}
