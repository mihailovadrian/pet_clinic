package com.mihailov.pet_clinic.services;

import com.mihailov.pet_clinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long Id);
    Vet save(Vet owner);
    Set<Vet> findAll();

}
