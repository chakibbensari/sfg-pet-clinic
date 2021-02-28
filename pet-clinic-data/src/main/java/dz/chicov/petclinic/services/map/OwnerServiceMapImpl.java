package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.services.OwnerService;
import dz.chicov.petclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceMapImpl extends AbstractServiceMap<Owner, Long> implements OwnerService {

    private PetService petService;

    public OwnerServiceMapImpl(PetService petService) {
        this.petService = petService;
    }

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
        if(owner != null){
            if(!owner.getPets().isEmpty()){
                owner.getPets().forEach(pet ->{
                    if(pet.getId() == null){
                        petService.save(pet);
                    }
                });

            }
        } else {
            throw new RuntimeException("Cannot save null Owner");
        }
        return super.save(owner);
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
