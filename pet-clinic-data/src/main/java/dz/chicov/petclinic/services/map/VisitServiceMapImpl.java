package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Visit;
import dz.chicov.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMapImpl extends AbstractServiceMap<Visit, Long> implements VisitService {

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit save(Visit visit) {
        if(visit == null || visit.getPet() == null || visit.getPet().getId() == null
                || visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null
                || visit.getPet().getPetType() == null || visit.getPet().getPetType().getId() == null){
            throw new RuntimeException("");
        }
        return super.save(visit);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
