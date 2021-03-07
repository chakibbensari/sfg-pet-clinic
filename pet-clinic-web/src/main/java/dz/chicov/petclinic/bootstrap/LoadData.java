package dz.chicov.petclinic.bootstrap;

import dz.chicov.petclinic.model.*;
import dz.chicov.petclinic.services.OwnerService;
import dz.chicov.petclinic.services.VetService;
import dz.chicov.petclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadData implements CommandLineRunner{

    private final OwnerService ownerService;
    private final VetService vetService;
    private final VisitService visitService;

    public LoadData(OwnerService ownerService, VetService vetService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType catPetType = createPetType("CAT");
        PetType dogPetType = createPetType("DOG");

        Owner owner = createOwner("Thompson", "John", "20 rue magnifique", "Manchester", "0610253658");
        Owner owner1 = createOwner("Shwadrzmûller", "Maximilian", "65 rue awersome", "London", "0613153658");

        Pet cat = createPet("PIPO", catPetType, owner);
        Pet dog = createPet("LAIKA", dogPetType, owner1);

        owner.getPets().add(cat);
        owner1.getPets().add(dog);

        ownerService.save(owner);
        ownerService.save(owner1);

        Visit visit = createVisit(LocalDate.now(), "Sneezy Cat", cat);

        visitService.save(visit);

        System.out.println(visitService.findAll().size() + " Visits Loaded");

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

    private Visit createVisit(LocalDate date, String description, Pet pet){
        return Visit.builder().date(randomDate())
                .description(description)
                .pet(pet)
                .build();
    }

    private Specialty createSpecialty(String name){
        return Specialty.builder().name(name).build();
    }

    private PetType createPetType(String name){
        return PetType.builder().name(name).build();
    }

    private Pet createPet(String name,PetType petType, Owner owner){
        return Pet.builder().name(name)
                .petType(petType)
                .owner(owner)
                .birthDate(randomDate())
                .build();
    }

    private Vet createVet(String firstName, String lastName){
        return Vet.builder().firstName(firstName)
                .lastName(lastName)
                .build();
    }

    private Owner createOwner(String firstName, String lastName, String address, String city, String telephone){
        return Owner.builder().firstName(firstName)
                .lastName(lastName)
                .address(address)
                .city(city)
                .telephone(telephone)
                .build();
    }

    private LocalDate randomDate() {
        return LocalDate.of((int)(Math.random() * 21) + 2000,
                (int)(Math.random() * 12) + 1,
                (int)(Math.random() * 30) + 1);
    }

}
