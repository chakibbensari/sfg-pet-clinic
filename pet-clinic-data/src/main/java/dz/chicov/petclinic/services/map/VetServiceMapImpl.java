package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Vet;
import dz.chicov.petclinic.services.VetService;

import java.util.Set;
import java.util.stream.Collectors;

public class VetServiceMapImpl extends AbstractServiceMap<Vet, Long> implements VetService {
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Set<Vet> findByFirstName(String firstName){
        return super.list.values().stream().filter((Vet vet) -> vet.getFistName().equals(firstName)).collect(Collectors.toSet());
    }
}
