package com.mihailov.pet_clinic.repositories;

import com.mihailov.pet_clinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
