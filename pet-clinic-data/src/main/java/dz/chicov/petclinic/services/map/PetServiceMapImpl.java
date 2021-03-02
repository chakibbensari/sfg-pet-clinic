package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Pet;
import dz.chicov.petclinic.model.PetType;
import dz.chicov.petclinic.services.CRUDService;
import dz.chicov.petclinic.services.PetService;
import dz.chicov.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetServiceMapImpl extends AbstractServiceMap<Pet, Long> implements PetService {

    private PetTypeService petTypeService;

    public PetServiceMapImpl(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        if(pet != null){
            if(pet.getPetType() != null){
                if(pet.getPetType().getId() == null){
                    petTypeService.save(pet.getPetType());
                }
            }
        } else {
            throw new RuntimeException("Cannot save a null Pet");
        }
        return super.save(pet);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
