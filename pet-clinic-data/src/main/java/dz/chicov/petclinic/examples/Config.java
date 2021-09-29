package dz.chicov.petclinic.examples;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:datasource.properties")
@Configuration
public class Config {

	@Bean
	public ExampleDataSource exampleDataSource(@Value("${chicov.username}")String username, 
			@Value("${chicov.password}")String password, 
			@Value("${chicov.url}")String url) {
		ExampleDataSource dataSource = new ExampleDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		return dataSource;
	}
}
