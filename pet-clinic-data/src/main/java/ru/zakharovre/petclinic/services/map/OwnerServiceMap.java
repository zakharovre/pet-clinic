package ru.zakharovre.petclinic.services.map;

import java.util.Set;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.zakharovre.petclinic.models.Owner;
import ru.zakharovre.petclinic.models.Pet;
import ru.zakharovre.petclinic.services.OwnerService;
import ru.zakharovre.petclinic.services.PetService;
import ru.zakharovre.petclinic.services.PetTypeService;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return super.findAll().stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner save(Owner owner) {
        if (owner != null) {
            if (owner.getPets() != null) {
                owner.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }
                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
       super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

}
