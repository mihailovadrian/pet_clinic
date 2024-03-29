package com.mihailov.pet_clinic.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Visits")
public class Visit extends BaseEntity {
    @Column(name = "Date")
    private LocalDate date;
    @Column(name = "Description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
