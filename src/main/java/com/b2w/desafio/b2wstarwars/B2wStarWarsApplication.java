package com.b2w.desafio.b2wstarwars;

import com.b2w.desafio.b2wstarwars.services.SWAPIService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class B2wStarWarsApplication {

	public static void main(String[] args) {
		SpringApplication.run(B2wStarWarsApplication.class, args);
	}

}
