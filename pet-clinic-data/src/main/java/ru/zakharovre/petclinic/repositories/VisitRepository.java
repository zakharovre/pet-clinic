package ru.zakharovre.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.zakharovre.petclinic.models.Visit;

public interface VisitRepository  extends CrudRepository<Visit, Long> {

}
