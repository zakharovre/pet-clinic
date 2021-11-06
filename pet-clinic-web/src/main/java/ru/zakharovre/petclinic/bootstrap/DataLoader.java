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
import ru.zakharovre.petclinic.models.Speciality;
import ru.zakharovre.petclinic.models.Vet;
import ru.zakharovre.petclinic.models.Visit;
import ru.zakharovre.petclinic.services.OwnerService;
import ru.zakharovre.petclinic.services.PetTypeService;
import ru.zakharovre.petclinic.services.SpecialityService;
import ru.zakharovre.petclinic.services.VetService;
import ru.zakharovre.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
            SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count==0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("PetTypes have been loaded");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        specialityService.save(radiology);
        specialityService.save(surgery);
        specialityService.save(dentistry);

        System.out.println("Specialities have been loaded");

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

        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("wet shit");
        visit.setPet(loverPet);
        visitService.save(visit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Hannibal");
        vet1.setLastName("Lecter");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Steve");
        vet2.setLastName("Jobs");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Vets have been loaded");
    }
}
