package ru.zakharovre.petclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zakharovre.petclinic.models.Speciality;

public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

}
