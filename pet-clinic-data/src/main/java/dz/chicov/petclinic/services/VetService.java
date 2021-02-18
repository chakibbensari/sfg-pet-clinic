package dz.chicov.petclinic.services;


import dz.chicov.petclinic.model.Vet;

import java.util.Set;

public interface VetService extends CRUDService<Vet, Long>{
    Set<Vet> findByFirstName(String firstName);
}
