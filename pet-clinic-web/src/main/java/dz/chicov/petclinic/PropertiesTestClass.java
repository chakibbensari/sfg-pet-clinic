package dz.chicov.petclinic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:test.properties")
public class PropertiesTestClass {

//    @Autowired
//    private Environment env;

    @Value("${path}")
    private String path;

    @Bean
    public static PropertySourcesPlaceholderConfigurer test(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public TestClass getThing(){
        TestClass testClass = new TestClass();
//        testClass.path = env.getProperty("Path");
        testClass.path = path;
        return testClass;
    }
}
