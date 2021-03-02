package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Pet;
import dz.chicov.petclinic.repositories.PetRepository;
import dz.chicov.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class PetServiceSDImpl implements PetService {

    private PetRepository petRepository;

    public PetServiceSDImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> Pets = new HashSet<>();
        petRepository.findAll().forEach(Pets::add);
        return Pets;
    }

    @Override
    public Pet save(Pet Pet) {
        return petRepository.save(Pet);
    }

    @Override
    public void delete(Pet Pet) {
        petRepository.delete(Pet);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
