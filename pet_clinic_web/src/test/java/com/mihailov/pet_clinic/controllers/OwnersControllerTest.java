package com.mihailov.pet_clinic.controllers;

import com.mihailov.pet_clinic.model.Owner;
import com.mihailov.pet_clinic.repositories.OwnerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnersControllerTest {
    @Mock
    OwnerService ownerService;
    @InjectMocks
    OwnersController controller;
    Set<Owner> ownerSet;
    MockMvc mvc;

    @BeforeEach
    void setUp() {
        //Init
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
        ownerSet = new HashSet<>();
        Owner o1 = new Owner(), o2 = new Owner(), o3 = new Owner();
        o1.setId(1L);
        o2.setId(2l);
        o3.setId(3l);
        ownerSet.add(o1);
        ownerSet.add(o2);
        ownerSet.add(o3);
    }
/*
    @Test
    void listOwnersByIndex() {
        when(ownerService.findAll()).thenReturn(ownerSet);
        try {
            mvc.perform(get("/owners")).andExpect(status().isOk())
                    .andExpect(view().name("owners/index"))
                    .andExpect(model().attribute("owners", hasSize(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    @Test
    void findOwners() {
        try {
            mvc.perform(get("/owners/find")).andExpect(status().isOk())
                    .andExpect(view().name("notImpl"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void showOwner() {
        Owner owner = new Owner();
        owner.setId(1l);
        when(ownerService.findById(anyLong())).thenReturn(Optional.of(owner));
        try {
            mvc.perform(get("/owners/123")).andExpect(status().isOk())
                    .andExpect(view().name("owners/ownerDetails"))
                    .andExpect(model().attribute("owner", Matchers.hasProperty("id", is(1l))));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}