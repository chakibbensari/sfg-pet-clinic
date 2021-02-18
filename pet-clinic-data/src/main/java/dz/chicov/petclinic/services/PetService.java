package dz.chicov.petclinic.services;

import dz.chicov.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Set<Pet> findAll();
    Pet save(Pet pet);
}
