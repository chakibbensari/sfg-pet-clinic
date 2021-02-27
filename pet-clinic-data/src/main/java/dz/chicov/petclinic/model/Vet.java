package dz.chicov.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public Set<Specialty> addSpecialty(Specialty specialty){
        this.specialties.add(specialty);
        return this.specialties;
    }

    public Set<Specialty> removeSpecialty(Specialty specialty){
        this.specialties.remove(specialty);
        return this.specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
