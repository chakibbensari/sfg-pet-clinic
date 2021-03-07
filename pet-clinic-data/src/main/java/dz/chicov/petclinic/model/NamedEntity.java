package dz.chicov.petclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class NamedEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    public NamedEntity(Long id, String name) {
        super(id);
        this.name = name;
    }
}
