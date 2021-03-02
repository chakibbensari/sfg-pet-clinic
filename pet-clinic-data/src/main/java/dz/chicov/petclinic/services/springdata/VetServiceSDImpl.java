package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Vet;
import dz.chicov.petclinic.repositories.VetRepository;
import dz.chicov.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class VetServiceSDImpl implements VetService {

    private VetRepository vetRepository;

    public VetServiceSDImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet save(Vet vet) {
        return vetRepository.save(vet);
    }

    @Override
    public void delete(Vet vet) {
        vetRepository.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }

    @Override
    public Set<Vet> findByFirstName(String firstName) {
        return vetRepository.findAllByFirstName(firstName);
    }
}
