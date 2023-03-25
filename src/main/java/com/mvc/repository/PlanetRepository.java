package com.mvc.repository;

import com.mvc.entity.Planet;
import com.mvc.entity.PlanetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet,Long> { // JpaRepository - zawiera CrudRepository
    //<Planet -> typ przechowywanego obiektu
    //Long> -> typ id przechowywanego obiektu
    //pomaga to ustawić odpowiednie parametry metodom JPA np save()

    List<Planet> findByType(PlanetType type);
    //metoda generowana "w locie" przez Spring JPA. Spring "skanuje" metody po ich nazwach i ustawionych typach
    // wykorzystując do tego refleksje i sam przygotowuje odpowiednią implementację tego interfejsu, która zostanie
    // wstrzyknięta


    //top3 planety pod względem populacji malejąco
    List<Planet> findTop3ByOrderByPopulationDesc();


}
