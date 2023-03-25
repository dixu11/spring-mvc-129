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



}
