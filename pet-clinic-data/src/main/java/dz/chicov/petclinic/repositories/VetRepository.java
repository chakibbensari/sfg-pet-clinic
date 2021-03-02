package dz.chicov.petclinic.repositories;

import dz.chicov.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface VetRepository extends CrudRepository<Vet, Long> {

    public Set<Vet> findAllByFirstName(String firstName);
}
