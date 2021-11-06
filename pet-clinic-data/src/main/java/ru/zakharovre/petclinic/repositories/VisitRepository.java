package ru.zakharovre.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharovre.petclinic.models.Visit;

public interface VisitRepository  extends JpaRepository<Visit, Long> {

}
