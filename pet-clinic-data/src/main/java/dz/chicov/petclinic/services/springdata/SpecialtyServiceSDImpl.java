package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Specialty;
import dz.chicov.petclinic.repositories.SpecialtyRepository;
import dz.chicov.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class SpecialtyServiceSDImpl extends AbstractServiceSDImpl<Specialty, Long, SpecialtyRepository> implements SpecialtyService {

    public SpecialtyServiceSDImpl(SpecialtyRepository specialtyRepository) {
        super(specialtyRepository);
    }

}
