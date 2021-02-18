package dz.chicov.petclinic.services;

import dz.chicov.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);
    Set<Owner> findByFirstName(String firstName);
    Set<Owner> findAll();
    Owner save(Owner owner);
}
