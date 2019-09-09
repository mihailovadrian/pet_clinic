package com.mihailov.pet_clinic.repositories;

import com.mihailov.pet_clinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerService extends CrudRepository<Owner, Long> {
    public Owner findOwnerByLastName(String LastName);

}
