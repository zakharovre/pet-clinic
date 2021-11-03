package ru.zakharovre.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import ru.zakharovre.petclinic.models.BaseEntity;

public abstract class AbstractMapService<E extends BaseEntity, ID extends Long> {

    protected Map<Long, E> map = new HashMap<>();

    Set<E> findAll() {
        return new HashSet<>(map.values());
    }

    E findByID(ID id) {
        return map.get(id);
    }

    E save(E entity) {
        if(entity != null) {
            if(entity.getId() == null) {
                entity.setId(getNextId());
            }
            map.put(entity.getId(), entity);
        } else {
            throw new RuntimeException("Entity cannot be null");
        }
        return entity;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(E entity) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
    }

    private Long getNextId() {
        Long nextId;
        try{
            nextId = Collections.max(map.keySet()) + 1L;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}
