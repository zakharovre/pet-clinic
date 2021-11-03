package ru.zakharovre.petclinic.services;

import ru.zakharovre.petclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
