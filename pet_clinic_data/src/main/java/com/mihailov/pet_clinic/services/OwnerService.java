package com.mihailov.pet_clinic.services;

import com.mihailov.pet_clinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
