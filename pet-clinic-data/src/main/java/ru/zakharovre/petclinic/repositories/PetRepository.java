package ru.zakharovre.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharovre.petclinic.models.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
