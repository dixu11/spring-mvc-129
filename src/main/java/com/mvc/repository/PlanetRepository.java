package com.mvc.repository;

import com.mvc.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet,Long> { // JpaRepository - zawiera CrudRepository
}
