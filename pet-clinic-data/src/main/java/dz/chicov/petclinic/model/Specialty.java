package dz.chicov.petclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id", callSuper = true)
@Entity
@Table(name = "specialties")
public class Specialty extends NamedEntity{

    @Builder
    public Specialty(Long id, String name) {
        super(id, name);
    }
}
