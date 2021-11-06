package ru.zakharovre.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharovre.petclinic.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
