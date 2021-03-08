package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Pet;
import dz.chicov.petclinic.repositories.PetRepository;
import dz.chicov.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("springdata")
public class PetServiceSDImpl extends AbstractServiceSDImpl<Pet, Long, PetRepository> implements PetService {

    public PetServiceSDImpl(PetRepository repository) {
        super(repository);
    }
}
