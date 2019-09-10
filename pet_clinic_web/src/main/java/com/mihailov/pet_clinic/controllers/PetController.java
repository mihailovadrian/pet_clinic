package com.mihailov.pet_clinic.controllers;

import com.mihailov.pet_clinic.model.Owner;
import com.mihailov.pet_clinic.model.PetType;
import com.mihailov.pet_clinic.services.OwnerService;
import com.mihailov.pet_clinic.services.PetService;
import com.mihailov.pet_clinic.services.PetTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
    private final PetService pets;
    private final OwnerService owners;
    private final PetTypeService petTypeService;

    public PetController(PetService pets, OwnerService owners, PetTypeService petTypeService) {
        this.pets = pets;
        this.owners = owners;
        this.petTypeService = petTypeService;
    }

    @ModelAttribute("types")
    public Collection<PetType> populatePetTypes() {
        return petTypeService.findAll();
    }

    @ModelAttribute("owner")
    public Owner findOwner(@PathVariable Long ownerId) {
        return owners.findById(ownerId);
    }

    @InitBinder("owner")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

}
