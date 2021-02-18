package dz.chicov.petclinic.services;


import dz.chicov.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);
    Set<Vet> findByFirstName(String firstName);
    Set<Vet> findAll();
    Vet save(Vet vet);
}
