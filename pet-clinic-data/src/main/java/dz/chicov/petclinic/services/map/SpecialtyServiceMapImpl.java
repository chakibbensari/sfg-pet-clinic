package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Specialty;
import dz.chicov.petclinic.services.CRUDService;

import java.util.Set;

public class SpecialtyServiceMapImpl extends AbstractServiceMap<Specialty, Long> implements CRUDService<Specialty, Long> {

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Specialty save(Specialty specialty) {
        return super.save(specialty);
    }

    @Override
    public void delete(Specialty specialty) {
        super.delete(specialty);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
