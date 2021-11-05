package ru.zakharovre.petclinic.bootstrap;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.zakharovre.petclinic.models.Owner;
import ru.zakharovre.petclinic.models.Pet;
import ru.zakharovre.petclinic.models.PetType;
import ru.zakharovre.petclinic.models.Vet;
import ru.zakharovre.petclinic.services.OwnerService;
import ru.zakharovre.petclinic.services.PetTypeService;
import ru.zakharovre.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("PetTypes have been loaded");

        Owner owner1 = new Owner();
        owner1.setFirstName("KeK");
        owner1.setLastName("LoL");
        owner1.setAddress("Funny Street");
        owner1.setCity("City of Fun");
        owner1.setTelephone("555-55-55");
        Pet kekPet = new Pet();
        kekPet.setName("Fluffy");
        kekPet.setPetType(dog);
        kekPet.setOwner(owner1);
        kekPet.setBirthDate(LocalDate.of(2012,5,2));
        owner1.getPets().add(kekPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Animal");
        owner2.setLastName("Lover");
        owner2.setAddress("Lust Street");
        owner2.setCity("Lust City");
        owner2.setTelephone("222-22-22");
        Pet loverPet = new Pet();
        loverPet.setName("Asshole");
        loverPet.setPetType(cat);
        loverPet.setOwner(owner2);
        loverPet.setBirthDate(LocalDate.of(2015, 11, 11));
        owner2.getPets().add(loverPet);
        ownerService.save(owner2);

        System.out.println("Owners have been loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Hannibal");
        vet1.setLastName("Lecter");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Steve");
        vet2.setLastName("Jobs");
        vetService.save(vet2);

        System.out.println("Vets have been loaded");
    }
}
