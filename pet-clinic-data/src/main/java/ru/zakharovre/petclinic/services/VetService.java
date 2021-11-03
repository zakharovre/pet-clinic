package ru.zakharovre.petclinic.services;

import java.util.Set;
import ru.zakharovre.petclinic.models.Vet;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
