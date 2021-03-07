package dz.chicov.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity{

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    @Builder
    public Pet(Long id, String name, LocalDate birthDate, PetType petType, Owner owner, Set<Visit> visits) {
        super(id, name);
        this.birthDate = birthDate;
        this.petType = petType;
        this.owner = owner;
        this.visits = visits;
    }

    public Pet addvisit(Visit visit){
        getVisits().add(visit);
        return this;
    }

    public Pet removevisit(Visit visit){
        getVisits().remove(visit);
        return this;
    }

}
