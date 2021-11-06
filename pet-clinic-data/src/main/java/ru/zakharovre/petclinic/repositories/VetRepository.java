package ru.zakharovre.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharovre.petclinic.models.Vet;

public interface VetRepository extends JpaRepository<Vet, Long> {

}
