package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.BaseEntity;
import dz.chicov.petclinic.services.CRUDService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public class AbstractServiceSDImpl<T extends BaseEntity, ID, R extends CrudRepository<T, ID>> implements CRUDService<T, ID> {

    protected final R repository;

    public AbstractServiceSDImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Set<T> findAll() {
        Set<T> set = new HashSet<T>();
        repository.findAll().forEach(set::add);
        return set;
    }

    @Override
    public T save(T t) {
        return repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
