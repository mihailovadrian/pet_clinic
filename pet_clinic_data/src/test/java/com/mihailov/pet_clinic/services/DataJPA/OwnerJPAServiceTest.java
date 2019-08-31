package com.mihailov.pet_clinic.services.DataJPA;

import com.mihailov.pet_clinic.repositories.OwnerRepository;
import com.mihailov.pet_clinic.repositories.PetRepository;
import com.mihailov.pet_clinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerJPAService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }
}