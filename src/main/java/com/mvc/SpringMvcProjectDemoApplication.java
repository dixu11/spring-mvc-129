package com.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //zawiera @ComponentScan -> sprawia że spring szuka adnotacji @Component
public class SpringMvcProjectDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcProjectDemoApplication.class, args);
		//Inversion of Control - odpalamy framework i to on tworzy nasze obiekty i odpala ich metody
		//Do tworzenia obiektów wykorzystujemy adnotacje @Component + @Bean
		//@Comonent -> dla naszych klas
		//@Bean -> dla klas których nie możemy edytować np. Scanner, RestTemplate, ObjectMapper itp
		//W komponentach wykorzystywany jest domyślnie konstruktor -> wstrzykiwanie zależności!
	}
}

/*
* Plan:
* można wytworzyć port
* port jest przypisany do konkretnej planety
*
* imperator za bardzo dużą cenę może również wytworzyć planete która od razu będzie jego
* żeby wytworzyć port trzeba być zalogowanym na konkretnego imperatora
* imperator może wytworzyć port wyłącznie na posiadanej planecie
* podczas kupowania portu trzeba zapłacić (potrąca kredyty)
* */
