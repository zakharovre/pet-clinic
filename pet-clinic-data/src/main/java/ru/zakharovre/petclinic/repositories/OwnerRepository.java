package ru.zakharovre.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.zakharovre.petclinic.models.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
