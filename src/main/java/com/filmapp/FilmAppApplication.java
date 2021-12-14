package com.filmapp;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableMongock
public class FilmAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmAppApplication.class, args);
	}

}
