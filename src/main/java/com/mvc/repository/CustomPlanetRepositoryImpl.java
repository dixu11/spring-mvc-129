package com.mvc.repository;

import com.mvc.entity.Planet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
//ręczna implementacja metody z repozytorium wymaga klasy. Interfejs jest potrzebny aby powiązać ją z pulą głównego repo
public class CustomPlanetRepositoryImpl implements CustomPlanetRepository{

    @PersistenceContext
    private EntityManager entityManager;
    //zlecam springowi podstawienie EntityManagera

    @Override
    public List<Planet> findTop3OnEntityManager() {
        //Planet.class aby nie było problemu z generycznymi typami
       List<Planet> planets = entityManager.createQuery("from Planet p order by p.population desc limit 3",Planet.class)
               .getResultList();
        return planets;
    }
}
