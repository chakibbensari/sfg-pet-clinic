package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.model.Pet;
import dz.chicov.petclinic.model.PetType;
import dz.chicov.petclinic.services.CRUDService;
import dz.chicov.petclinic.services.OwnerService;
import dz.chicov.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMapImpl extends AbstractServiceMap<Pet, Long> implements CRUDService<Pet, Long> {

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
                    PetType petType = petTypeService.save(pet.getPetType());
                    pet.getPetType().setId(petType.getId());
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
