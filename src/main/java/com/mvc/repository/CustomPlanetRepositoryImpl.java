package com.mvc.repository;

import com.mvc.entity.Planet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CustomPlanetRepositoryImpl implements CustomPlanetRepository{
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Planet> populated() {
        List<Planet> resultList = manager.createQuery("from Planet p where p.population > 1000",Planet.class).getResultList();
        return resultList;
    }
}
