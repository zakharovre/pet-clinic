package ru.zakharovre.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.zakharovre.petclinic.models.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
