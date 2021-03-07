package dz.chicov.petclinic.services.springdata;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.repositories.OwnerRepository;
import dz.chicov.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.Mockito.*;

class OwnerServiceSDImplTest {

    private OwnerService ownerServiceSDImpl;

    @Mock
    private OwnerRepository ownerRepository;

    Set<Owner> owners = new HashSet<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        ownerServiceSDImpl = new OwnerServiceSDImpl(ownerRepository);
        owners.add(Owner.builder().id(1L).firstName("TEST").build());
    }

    @Test
    void findById() {
        Optional<Owner> owner = Optional.of(owners.iterator().next());
        when(ownerRepository.findById(1L)).thenReturn(owner);
        Owner ow = ownerServiceSDImpl.findById(1L);
        assertNotNull(ow);
        assertEquals(1L, ow.getId());
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> ows = ownerServiceSDImpl.findAll();
        assertEquals(owners, ows);
    }

    @Test
    void save() {
        ownerServiceSDImpl.save(owners.iterator().next());
        when(ownerRepository.save(any(Owner.class))).thenReturn(owners.iterator().next());
        verify(ownerRepository, times(1)).save(owners.iterator().next());
    }

    @Test
    void delete() {
        ownerServiceSDImpl.delete(owners.iterator().next());
        verify(ownerRepository, times(1)).delete(owners.iterator().next());
    }

    @Test
    void deleteById() {
        ownerServiceSDImpl.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(1L);
    }

    @Test
    void findByFirstName() {
        when(ownerRepository.findAllByFirstName("TEST")).thenReturn(owners);
        Set<Owner> ows = ownerServiceSDImpl.findByFirstName("TEST");
        assertEquals(owners, ows);
    }
}