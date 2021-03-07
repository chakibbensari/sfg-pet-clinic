package dz.chicov.petclinic.services.map;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.model.Pet;
import dz.chicov.petclinic.model.PetType;
import dz.chicov.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapImplTest {

    private OwnerService ownerServiceMap;

    private Owner owner;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMapImpl(new PetServiceMapImpl(new PetTypeServiceMapImpl()));
        owner = Owner.builder().id(1L).firstName("TEST").build();
        ownerServiceMap.save(owner);
    }

    @Test
    void findByFirstName() {
        Set<Owner> ows = ownerServiceMap.findByFirstName(owner.getFirstName());

        assertEquals(1, ows.size());
        assertNotNull(ows.stream().filter(o -> o.getFirstName().equals(owner.getFirstName())).findFirst().orElse(null));
    }

    @Test
    void findById() {
        Owner ow = ownerServiceMap.findById(owner.getId());
        assertNotNull(ow);
        assertEquals(owner.getId(), ow.getId());
    }

    @Test
    void findByIdNotFound() {
        Owner ow = ownerServiceMap.findById(2L);
        assertNull(ow);
    }

    @Test
    void save() {
        Owner o = Owner.builder().build();
        Owner ow = ownerServiceMap.save(o);

        assertEquals(2, ownerServiceMap.findAll().size());
        assertNotNull(ownerServiceMap.findAll().stream().filter(x -> x.getId().equals(owner.getId() + 1)).findFirst().orElse(null));
    }

    @Test
    void saveWithCompletePet() {
        Owner o = Owner.builder().build();
        PetType petType = PetType.builder().name("CAT").build();
        o.addPet(Pet.builder().birthDate(LocalDate.now()).name("PIPO").owner(o).petType(petType).build());
        Owner ow = ownerServiceMap.save(o);

        assertEquals(1, ownerServiceMap.findAll().stream().filter(
                x -> x.getId().equals(owner.getId() + 1))
                .findFirst()
                .orElse(null)
                .getPets().size());
    }

    @Test
    void saveNull() {

        assertThrows(RuntimeException.class, () -> ownerServiceMap.save(null));
    }

    @Test
    void delete() {
        ownerServiceMap.delete(owner);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(owner.getId());

        assertEquals(0, ownerServiceMap.findAll().size());
    }
}