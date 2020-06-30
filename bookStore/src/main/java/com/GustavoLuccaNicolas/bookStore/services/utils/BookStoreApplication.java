package com.GustavoLuccaNicolas.bookStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.GustavoLuccaNicolas"})
@EnableJpaRepositories(basePackages = {"com.GustavoLuccaNicolas"}) // onde procurar as interfaces dos repositórios do JPA
@EntityScan(basePackages = {"com.GustavoLuccaNicolas"}) // onde procurar as entidades
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

}
