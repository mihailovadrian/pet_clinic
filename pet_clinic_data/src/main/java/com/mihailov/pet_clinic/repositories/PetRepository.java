package com.mihailov.pet_clinic.repositories;

import com.mihailov.pet_clinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
