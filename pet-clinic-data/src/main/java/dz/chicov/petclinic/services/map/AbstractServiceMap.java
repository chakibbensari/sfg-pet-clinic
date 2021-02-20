package dz.chicov.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract public class AbstractServiceMap<T, I>{

    protected Map<I, T> list = new HashMap<I, T>();

     public T findById(I id) {
        return list.get(id);
    }

    public Set<T> findAll() {
        return new HashSet<T>(list.values());
    }

    public T save(I id, T object) {
        return list.put(id, object);
    }

        public void delete(T object) {
        list.values().removeIf((T o) -> o.equals(object));
    }

    public void deleteById(I id) {
        list.remove(id);
    }
}
