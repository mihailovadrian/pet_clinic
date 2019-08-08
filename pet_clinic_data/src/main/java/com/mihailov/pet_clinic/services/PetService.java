package com.mihailov.pet_clinic.services;

import com.mihailov.pet_clinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long Id);
    Pet save(Pet owner);
    Set<Pet> findAll();
}
