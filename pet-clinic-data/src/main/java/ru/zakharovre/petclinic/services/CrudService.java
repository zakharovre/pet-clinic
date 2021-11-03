package ru.zakharovre.petclinic.services;

import java.util.Set;

public interface CrudService<E, ID> {

    Set<E> findAll();

    E findById(ID id);

    E save (E entity);

    void delete(E entity);

    void deleteById(ID id);

}
