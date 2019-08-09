package com.mihailov.pet_clinic.bootload;

import com.mihailov.pet_clinic.model.Owner;
import com.mihailov.pet_clinic.model.Vet;
import com.mihailov.pet_clinic.services.OwnerService;
import com.mihailov.pet_clinic.services.VetService;
import com.mihailov.pet_clinic.services.map.OwnerMapService;
import com.mihailov.pet_clinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootLoader implements CommandLineRunner {
    private final VetService vetService;
    private final OwnerService ownerService;

    public bootLoader(VetService vetService, OwnerService ownerService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setFirstName("Mihailov");
        owner1.setLastName("Adi");

        Owner owner2 = new Owner();
        owner2.setFirstName("Milov");
        owner2.setLastName("Adrian");
        ownerService.save(owner1);
        ownerService.save(owner2);
        //

        Vet vet = new Vet();
        vet.setFirstName("Medicuuu");
        vet.setLastName("Doctorus");

        Vet vet2 = new Vet();
        vet2.setFirstName("Hrisca");
        vet2.setLastName("Docilus");

        vetService.save(vet);
        vetService.save(vet2);
        System.out.println("Load information about owners and vets !");
    }
}
