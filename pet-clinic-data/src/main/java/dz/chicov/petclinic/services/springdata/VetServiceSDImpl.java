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
public class VetServiceSDImpl extends AbstractServiceSDImpl<Vet, Long, VetRepository>implements VetService {

    public VetServiceSDImpl(VetRepository vetRepository) {
        super(vetRepository);
    }

    @Override
    public Set<Vet> findByFirstName(String firstName) {
        Set<Vet> set = new HashSet<>();
        super.repository.findAllByFirstName(firstName).forEach(set::add);
        return set;
    }
}
