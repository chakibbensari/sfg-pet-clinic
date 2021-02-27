package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Vet;
import dz.chicov.petclinic.services.SpecialtyService;
import dz.chicov.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class VetServiceMapImpl extends AbstractServiceMap<Vet, Long> implements VetService {

    private SpecialtyService specialtyService;

    public VetServiceMapImpl(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if(vet != null){
            if(!vet.getSpecialties().isEmpty()){
                vet.getSpecialties().forEach(specialty -> {
                    if(specialty != null){
                        if(specialty.getId() == null) {
                            specialtyService.save(specialty);
                        }
                    }
                });
            }else {
                throw new RuntimeException("Vet should have at least one Specialty");
            }
        } else {
            throw new RuntimeException("Cannot save a  null Vet");
        }
        return super.save(vet);
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
        return super.list.values().stream().filter((Vet vet) -> vet.getFirstName().equals(firstName)).collect(Collectors.toSet());
    }
}
