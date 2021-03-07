package dz.chicov.petclinic.repositories;

import dz.chicov.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public Set<Owner> findAllByFirstName(String firstName);
}
