package com.avanade.tdc.preview.cosmos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SimpleCosmosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleCosmosApplication.class, args);
	}

}

@Component
class CosmosDemo {

	CosmosDemo(ApplicationRepository repository) {
		repository.save(new Application(null, "Simple Cosmos Application"));
		repository.findAll().forEach(System.out::println);
	}

}

interface ApplicationRepository extends MongoRepository<Application, String> { }

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Application {
	@Id
	private String id;
	private String name;
}
