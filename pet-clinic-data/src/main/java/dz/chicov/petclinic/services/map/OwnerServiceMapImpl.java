package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceMapImpl extends AbstractServiceMap<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findByFirstName(String firstName) {
        return super.list.values().stream().filter((Owner o) -> o.getFirstName().equals(firstName)).collect(Collectors.toSet());
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
