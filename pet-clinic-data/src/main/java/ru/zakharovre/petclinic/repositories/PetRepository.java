package ru.zakharovre.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.zakharovre.petclinic.models.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
