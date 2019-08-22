package com.mihailov.pet_clinic.repositories;

import com.mihailov.pet_clinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
