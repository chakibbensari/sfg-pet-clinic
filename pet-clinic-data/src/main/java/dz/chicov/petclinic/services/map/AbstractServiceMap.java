package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.BaseEntity;

import java.util.*;

abstract public class AbstractServiceMap<T extends BaseEntity, I extends Long>{

    protected Map<Long, T> list = new HashMap<>();

     public T findById(I id) {
        return list.get(id);
    }

    public Set<T> findAll() {
        return new HashSet<>(list.values());
    }

    public T save(T object) {
         if(object != null) {
             object.setId(getNextId());
             return list.put(object.getId(), object);
         } else {
             throw new RuntimeException("can't persist a null object.");
         }
    }

    public void delete(T object) {
        list.values().removeIf((T o) -> o.equals(object));
    }

    public void deleteById(I id) {
        list.remove(id);
    }

    private Long getNextId() {
         try {
             return Collections.max(list.keySet()) + 1;
         } catch(NoSuchElementException e){
             return 1L;
         }

    }
}
