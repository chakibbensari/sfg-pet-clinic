package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Specialty;
import dz.chicov.petclinic.repositories.SpecialtyRepository;
import dz.chicov.petclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdata")
public class SpecialtyServiceSDImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceSDImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElse(null);
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> Specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(Specialties::add);
        return Specialties;
    }

    @Override
    public Specialty save(Specialty Specialty) {
        return specialtyRepository.save(Specialty);
    }

    @Override
    public void delete(Specialty Specialty) {
        specialtyRepository.delete(Specialty);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
