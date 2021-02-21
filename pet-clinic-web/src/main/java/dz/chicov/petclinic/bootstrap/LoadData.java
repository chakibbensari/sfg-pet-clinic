package dz.chicov.petclinic.bootstrap;

import dz.chicov.petclinic.model.Owner;
import dz.chicov.petclinic.model.Person;
import dz.chicov.petclinic.model.Vet;
import dz.chicov.petclinic.services.OwnerService;
import dz.chicov.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;

    public LoadData(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = createOwner(1L, "Thompson", "John");
        Owner owner1 = createOwner(2L, "Shwadrzmûller", "Maximilian");
        Vet vet = createVet(1L, "Thompson", "John");
        Vet vet1 = createVet(2L, "Shwadrzmûller", "Maximilian");
        try {
            ownerService.save(owner);
            ownerService.save(owner1);
            vetService.save(vet1);
            vetService.save(vet);
            System.out.println(ownerService.findAll().size() + " Owners Loaded");
            System.out.println(vetService.findAll().size() + " Vets Loaded");
        } catch (Exception e){
            throw new Exception("Error during save", e);
        }
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
        person.setFirstName(firstName);
        person.setLastName(lastName);


    }
}
