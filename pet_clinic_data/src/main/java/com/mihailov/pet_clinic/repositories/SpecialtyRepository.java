package com.mihailov.pet_clinic.repositories;

import com.mihailov.pet_clinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
