package com.mvc.service;

import com.mvc.entity.Planet;
import com.mvc.entity.Port;
import com.mvc.repository.PlanetRepository;
import com.mvc.repository.PortRepository;
import com.mvc.request.BuildPortRequest;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PortService {

    private PlanetRepository planetRepository;
    private PortRepository portRepository;



    public PortService(PlanetRepository planetRepository, PortRepository portRepository) {
        this.planetRepository = planetRepository;
        this.portRepository = portRepository;
    }

    @Transactional
    public void createPort(BuildPortRequest request) {
        //znajdź planetę po nazwie
        Planet planet = planetRepository.findByName(request.getPlanetName())
                .orElseThrow(); //fajnie by było dodać własny wyjątek i obsługę w Controllerze
        //stwórz port
        Port port = new Port(request.getLvl());
        //dodaj jej port
        planet.setPort(port);
        //zapisz
        planetRepository.save(planet);
    }

}
