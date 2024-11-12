package com.kevenreyes.searchmovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchmoviesApplication  {
	

	public static void main(String[] args) {
		SpringApplication.run(SearchmoviesApplication.class, args);
		
	}


}





































// package com.kevenreyes.searchmovies;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.kevenreyes.searchmovies.principal.PrincipalApp;
// import com.kevenreyes.searchmovies.repository.SeriesRepository;

// @SpringBootApplication
// public class SearchmoviesApplication implements CommandLineRunner {
	
// 	@Autowired
// 	private SeriesRepository repository;

// 	public static void main(String[] args) {
// 		SpringApplication.run(SearchmoviesApplication.class, args);
// 	}

// 	@Override
// 	public void run(String... args) throws Exception {
// 		PrincipalApp principal = new PrincipalApp(repository);
// 		principal.showMenu();
// 	}

// }

