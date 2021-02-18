package dz.chicov.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity{

    private LocalDate birthDate;
    private PetType petType;
    private Owner owner;
}
