package ru.zakharovre.petclinic.services;

import java.util.Set;
import ru.zakharovre.petclinic.models.Owner;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
