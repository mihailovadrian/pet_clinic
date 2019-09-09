package com.mihailov.pet_clinic.services.DataJPA;

import com.mihailov.pet_clinic.model.Owner;
import com.mihailov.pet_clinic.repositories.OwnerRepository;
import com.mihailov.pet_clinic.repositories.PetRepository;
import com.mihailov.pet_clinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {
    public static final String SMITH = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @Mock
    PetRepository petRepository;

    @InjectMocks
    OwnerJPAService service;
    Owner returnOwner;

    @BeforeEach
    void setUp() {

        returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName(SMITH);

    }

    @Test
    void findByLastName() {

        when(ownerRepository.findOwnerByLastName(any())).thenReturn(returnOwner);
        Owner smith = service.findByLastName(SMITH);
        assertEquals(SMITH, smith.getLastName());
        verify(ownerRepository).findOwnerByLastName(any());
    }

    @Test
    void findAll() {
        //init
        Set<Owner> returnOwnerSet = new HashSet<>();
        Owner o1 = new Owner();
        Owner o2 = new Owner();
        o1.setId(1L);
        o2.setId(2L);
        returnOwnerSet.add(o1);
        returnOwnerSet.add(o2);

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);
        Set<Owner> result = service.findAll();
        assertNotNull(result);
        assertEquals(2, result.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = service.findById(1L);
        assertNotNull(owner);
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(1L);
        when(ownerRepository.save(any())).thenReturn(returnOwner);
        Owner savedOwner = service.save(owner);
        assertNotNull(savedOwner);
        verify(ownerRepository.save(any()));
    }

    @Test
    void delete() {
        service.delete(returnOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(ownerRepository).deleteById(anyLong());
    }
}