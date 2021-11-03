package ru.zakharovre.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.zakharovre.petclinic.models.Owner;
import ru.zakharovre.petclinic.models.Vet;
import ru.zakharovre.petclinic.services.OwnerService;
import ru.zakharovre.petclinic.services.VetService;
import ru.zakharovre.petclinic.services.map.OwnerServiceMap;
import ru.zakharovre.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Kek");
        owner1.setLastName("Lol");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Animal");
        owner2.setLastName("Lover");
        ownerService.save(owner2);

        System.out.println("Owners have been loaded");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Hannibal");
        vet1.setLastName("Lecter");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Steve");
        vet2.setLastName("Jobs");
        vetService.save(vet2);

        System.out.println("Vets have been loaded");
    }
}
