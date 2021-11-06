package ru.zakharovre.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.zakharovre.petclinic.models.Speciality;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {

}
