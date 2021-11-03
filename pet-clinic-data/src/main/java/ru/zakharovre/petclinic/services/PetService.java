package ru.zakharovre.petclinic.services;

import java.util.Set;
import ru.zakharovre.petclinic.models.Pet;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
