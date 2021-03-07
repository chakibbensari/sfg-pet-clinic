package dz.chicov.petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity{

    @Builder
    public Specialty(Long id, String name) {
        super(id, name);
    }
}
