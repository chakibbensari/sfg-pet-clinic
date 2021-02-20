package dz.chicov.petclinic.services;

import dz.chicov.petclinic.model.Pet;

public class PetServiceMapImpl extends AbstractServiceMap<Pet, Long> implements CRUDService<Pet, Long>{
    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
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
