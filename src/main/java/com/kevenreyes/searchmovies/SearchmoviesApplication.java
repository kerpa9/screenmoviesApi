package com.kevenreyes.searchmovies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevenreyes.searchmovies.principal.PrincipalApp;

@SpringBootApplication
public class SearchmoviesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SearchmoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PrincipalApp principal = new PrincipalApp();
		principal.showMenu();
	}

}
