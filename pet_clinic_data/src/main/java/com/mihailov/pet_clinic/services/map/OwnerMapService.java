package com.mihailov.pet_clinic.services.map;

import com.mihailov.pet_clinic.model.Owner;
import com.mihailov.pet_clinic.model.Pet;
import com.mihailov.pet_clinic.services.OwnerService;
import com.mihailov.pet_clinic.services.PetService;
import com.mihailov.pet_clinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPetSet() != null) {
                object.getPetSet().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet type is necessary !");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        //using Java 8
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName()
                        .equalsIgnoreCase(lastName)).findFirst().orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        //todo - impl
        return null;

    }
}
