package com.mihailov.pet_clinic.repositories;

import com.mihailov.pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findOwnerByLastName(String LastName);

    List<Owner> findAllByLastName(String lastName);

}
