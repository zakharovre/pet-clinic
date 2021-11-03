package ru.zakharovre.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<E, ID> {

    protected Map<ID, E> map = new HashMap<>();

    Set<E> findAll() {
        return new HashSet<>(map.values());
    }

    E findByID(ID id) {
        return map.get(id);
    }

    E save(ID id, E entity) {
        return map.put(id, entity);
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(E entity) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
    }
}
