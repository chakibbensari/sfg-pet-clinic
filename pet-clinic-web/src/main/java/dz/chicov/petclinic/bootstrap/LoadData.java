package dz.chicov.petclinic.bootstrap;

import dz.chicov.petclinic.model.*;
import dz.chicov.petclinic.services.OwnerService;
import dz.chicov.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        PetType catPetType = createPetType("CAT");
        PetType dogPetType = createPetType("DOG");

        Owner owner = createOwner("Thompson", "John", "20 rue magnifique", "Paradise", "0610253658");
        Owner owner1 = createOwner("Shwadrzmûller", "Maximilian", "65 rue awersome", "Paradise", "0613153658");

        Pet cat = createPet(catPetType, owner);
        Pet dog = createPet(dogPetType, owner1);

        owner.getPets().add(cat);
        owner1.getPets().add(dog);

        ownerService.save(owner);
        ownerService.save(owner1);

        System.out.println(ownerService.findAll().size() + " Owners Loaded");

        Specialty radiology = createSpecialty("Radiology");
        Specialty dentistry = createSpecialty("Dentistry");

        Vet vet = createVet("BENSARI", "Chakib");
        vet.addSpecialty(radiology);
        Vet vet1 = createVet("DIBOUN", "Zoubir");
        vet1.addSpecialty(dentistry);

        vetService.save(vet1);
        vetService.save(vet);
        System.out.println(vetService.findAll().size() + " Vets Loaded");

    }

    private Specialty createSpecialty(String name){
        Specialty specialty = new Specialty();
        specialty.setName(name);
        return specialty;
    }

    private PetType createPetType(String name){
        PetType petType = new PetType();
        petType.setName(name);
        return petType;
    }

    private Pet createPet(PetType petType, Owner owner){
        Pet pet = new Pet();
        pet.setPetType(petType);
        pet.setOwner(owner);
        pet.setBirthDate(LocalDate.of((int)(Math.random() * 21) + 2000,
                                    (int)(Math.random() * 12) + 1,
                                (int)(Math.random() * 30) + 1));
        return pet;
    }

    private Vet createVet(String firstName, String lastName){
        Vet vet = new Vet();
        createPerson(vet, firstName, lastName);
        return vet;
    }

    private Owner createOwner(String firstName, String lastName, String address, String city, String telephone){
        Owner owner = new Owner();
        owner.setAddress(address);
        owner.setCity(city);
        owner.setTelephone(telephone);
        createPerson(owner,firstName, lastName);
        return owner;
    }

    private void createPerson(Person person, String firstName, String lastName){

        person.setFirstName(firstName);
        person.setLastName(lastName);


    }
}
