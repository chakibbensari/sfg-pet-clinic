package dz.chicov.petclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="vets_specialties",
               joinColumns = @JoinColumn(name= "specialty_id"),
               inverseJoinColumns = @JoinColumn(name ="vet_id"))
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
