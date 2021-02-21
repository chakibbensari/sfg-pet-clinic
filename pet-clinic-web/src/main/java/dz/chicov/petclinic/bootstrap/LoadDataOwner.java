package dz.chicov.petclinic.bootstrap;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.model.Person;
import dz.chicov.petclinic.model.Vet;
import dz.chicov.petclinic.services.OwnerService;
import dz.chicov.petclinic.services.VetService;
import dz.chicov.petclinic.services.map.OwnerServiceMapImpl;
import dz.chicov.petclinic.services.map.VetServiceMapImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDataOwner implements CommandLineRunner{

    private OwnerService ownerServiceImpl;
    private VetService vetServiceImpl;

    public LoadDataOwner() {
        this.ownerServiceImpl = new OwnerServiceMapImpl();
        this.vetServiceImpl = new VetServiceMapImpl();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = createOwner(1L, "Thompson", "John");
        ownerServiceImpl.save(owner);

        Owner owner1 = createOwner(2L, "Shwadrzmûller", "Maximilian");
        ownerServiceImpl.save(owner1);

        System.out.println("Owners Loaded");

        Vet vet = createVet(1L, "Thompson", "John");
        vetServiceImpl.save(vet);

        Vet vet1 = createVet(2L, "Shwadrzmûller", "Maximilian");
        vetServiceImpl.save(vet1);

        System.out.println("Vets Loaded");

    }

    private Vet createVet(Long id, String firstName, String lastName){
        Vet vet = new Vet();
        createPerson(vet, id, firstName, lastName);
        return vet;
    }

    private Owner createOwner(Long id, String firstName, String lastName){
        Owner owner = new Owner();
        createPerson(owner, id, firstName, lastName);
        return owner;
    }

    private void createPerson(Person person, Long id, String firstName, String lastName){
        person.setId(id);
        person.setFistName(firstName);
        person.setLastName(lastName);


    }
}
