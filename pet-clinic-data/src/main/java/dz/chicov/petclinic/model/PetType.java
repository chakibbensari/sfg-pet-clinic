package dz.chicov.petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "pet_types")
public class PetType extends NamedEntity{

    @Builder
    public PetType(Long id, String name) {
        super(id, name);
    }
}
