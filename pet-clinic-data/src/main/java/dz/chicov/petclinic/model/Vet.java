package dz.chicov.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = true)
@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="vets_specialties",
               joinColumns = @JoinColumn(name= "specialty_id"),
               inverseJoinColumns = @JoinColumn(name ="vet_id"))
    private Set<Specialty> specialties = new HashSet<>();

    @Builder
    public Vet(Long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Set<Specialty> addSpecialty(Specialty specialty){
        this.specialties.add(specialty);
        return this.specialties;
    }

    public Set<Specialty> removeSpecialty(Specialty specialty){
        this.specialties.remove(specialty);
        return this.specialties;
    }
}
