package com.mihailov.pet_clinic.bootload;

import com.mihailov.pet_clinic.model.*;
import com.mihailov.pet_clinic.services.OwnerService;
import com.mihailov.pet_clinic.services.PetTypeService;
import com.mihailov.pet_clinic.services.SpecialtyService;
import com.mihailov.pet_clinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class bootLoader implements CommandLineRunner {
    private final VetService vetService;
    private final OwnerService ownerService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    public bootLoader(VetService vetService, OwnerService ownerService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.vetService = vetService;
        this.ownerService = ownerService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCat = petTypeService.save(cat);

        Specialty surgery=new Specialty();
        surgery.setDescription("surgery");

        Specialty dentist= new Specialty();
        dentist.setDescription("dentist");
        specialtyService.save(surgery);
        specialtyService.save(dentist);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mihailov");
        owner1.setLastName("Adi");
        owner1.setAddress("Str....");
        owner1.setCity("SV");
        owner1.setTelephone("0744");


        Pet pet = new Pet();
        pet.setPetType(savedDog);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner1);
        pet.setName("Boby");
        owner1.getPetSet().add(pet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Milov");
        owner2.setLastName("Adrian");
        owner1.setAddress("Str..NR..");
        owner1.setCity("BT");
        owner1.setTelephone("07114");
        ownerService.save(owner1);
        ownerService.save(owner2);

        Pet catPet = new Pet();
        catPet.setPetType(savedCat);
        catPet.setBirthDate(LocalDate.now());
        catPet.setOwner(owner2);
        catPet.setName("Cat");
        owner2.getPetSet().add(pet);

        Vet vet = new Vet();
        vet.setFirstName("Medicuuu");
        vet.setLastName("Doctorus");
        vet.getSpecialtySet().add(dentist);


        Vet vet2 = new Vet();
        vet2.setFirstName("Hrisca");
        vet2.setLastName("Docilus");
        vet2.getSpecialtySet().add(surgery);

        vetService.save(vet);
        vetService.save(vet2);
        System.out.println("Load information about owners and vets !");
    }
}
