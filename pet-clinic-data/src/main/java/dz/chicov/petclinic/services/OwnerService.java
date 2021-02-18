package dz.chicov.petclinic.services;

import dz.chicov.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CRUDService<Owner, Long>{

    Set<Owner> findByFirstName(String firstName);
}
