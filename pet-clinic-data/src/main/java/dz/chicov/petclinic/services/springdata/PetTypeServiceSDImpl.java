package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.PetType;
import dz.chicov.petclinic.repositories.PetTypeRepository;
import dz.chicov.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class PetTypeServiceSDImpl extends AbstractServiceSDImpl<PetType, Long, PetTypeRepository> implements PetTypeService {

    public PetTypeServiceSDImpl(PetTypeRepository petTypeRepository) {
        super(petTypeRepository);
    }

}
