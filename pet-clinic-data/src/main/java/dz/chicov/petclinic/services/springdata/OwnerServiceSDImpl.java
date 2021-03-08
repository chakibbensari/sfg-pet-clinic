package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.repositories.OwnerRepository;
import dz.chicov.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class OwnerServiceSDImpl extends AbstractServiceSDImpl<Owner, Long, OwnerRepository> implements OwnerService {

    public OwnerServiceSDImpl(OwnerRepository ownerRepository) {
        super(ownerRepository);
    }

    @Override
    public Set<Owner> findByFirstName(String firstName) {
        Set<Owner> set = new HashSet<>();
        super.repository.findAllByFirstName(firstName).forEach(set::add);
        return set;
    }
}
