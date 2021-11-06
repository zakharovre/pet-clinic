package ru.zakharovre.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharovre.petclinic.models.PetType;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {

}
