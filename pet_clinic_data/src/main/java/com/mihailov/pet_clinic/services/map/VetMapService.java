package com.mihailov.pet_clinic.services.map;

import com.mihailov.pet_clinic.model.Specialty;
import com.mihailov.pet_clinic.model.Vet;
import com.mihailov.pet_clinic.services.SpecialtyService;
import com.mihailov.pet_clinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {
        if (object.getSpecialtySet().size() > 0) {
            object.getSpecialtySet().forEach(specialty -> {
                if (specialty.getId() == null) {
                    Specialty savedSpec=specialtyService.save(specialty);
                    specialty.setId(savedSpec.getId());
                }
            });
            return super.save(object);
        }
        return null;
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
