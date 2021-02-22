package dz.chicov.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PetclinicApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx =  SpringApplication.run(PetclinicApplication.class, args);
        TestClass testClass = ctx.getBean(TestClass.class);
        System.out.println(testClass.path);
    }

}
