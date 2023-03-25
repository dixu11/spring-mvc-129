package com.mvc.repository;

import com.mvc.entity.Planet;
import com.mvc.entity.PlanetType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

//możemy dorzucić swoje implementacje poprzez podpięcie dodatkowych ZAIMPLEMENTOWANYCH interfejsów (CustomPlanetRepository)
public interface PlanetRepository extends JpaRepository<Planet,Long>,CustomPlanetRepository { // JpaRepository - zawiera CrudRepository
    //<Planet -> typ przechowywanego obiektu
    //Long> -> typ id przechowywanego obiektu
    //pomaga to ustawić odpowiednie parametry metodom JPA np save()

    List<Planet> findByType(PlanetType type);
    //metoda generowana "w locie" przez Spring JPA. Spring "skanuje" metody po ich nazwach i ustawionych typach
    // wykorzystując do tego refleksje i sam przygotowuje odpowiednią implementację tego interfejsu, która zostanie
    // wstrzyknięta


    //top3 planety pod względem populacji malejąco
    //List<Planet> findTop3ByOrderByPopulationDesc();

    //składnia tej metody wynika z wykorzystania słów kluczowych zdefiniowanych w dokumentacji JPA ( można też poszukać tutoriali)
    //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.limit-query-result

    @Query("from Planet p order by p.population desc limit 3")
    List<Planet> findTop3();
    //nazwa metody w tym podejściu zostaje zignorowana a JPA bierze pod uwagę przekazy kod HQL
    //w HQL wykorzystujemy nazwy klas i nazwy pól a nie tabel i kolumn

    Optional<Planet> findByName(String name);

}
