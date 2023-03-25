package com.mvc.repository;

import com.mvc.entity.Planet;
import com.mvc.entity.PlanetType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet,Long>,CustomPlanetRepository { // JpaRepository - zawiera CrudRepository

    List<Planet> findByType(PlanetType type);

}
