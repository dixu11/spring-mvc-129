package com.mvc.repository;

import com.mvc.entity.Planet;

import java.util.List;

//tutaj daję metody które chcę w pełni samodzielnie zaimplementować
public interface CustomPlanetRepository {
    List<Planet> findTop3OnEntityManager();
}
