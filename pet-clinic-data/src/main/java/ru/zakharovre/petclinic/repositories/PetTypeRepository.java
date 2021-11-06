package ru.zakharovre.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.zakharovre.petclinic.models.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
