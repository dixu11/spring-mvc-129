package com.mvc.configuration;

import com.mvc.entity.Imperator;
import com.mvc.repository.ImperatorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration //to samo co @Component ale podpowiada kontekst
@Profile("dev") // działa tylko dla wybranego profilu
public class DummyDataInitialization {

    private ImperatorRepository repository;
    @Value("${myProperty}") //loading data from property file - executes when context loads - AFTER CONSTRUCTOR
    private String loadedProperty;

    public DummyDataInitialization(ImperatorRepository repository) {
        this.repository = repository;
    }

    @PostConstruct //execute this method after initializing component
    public void addDummyImperator() {
        if (repository.count() > 0) {
            return;
        }
        repository.save(new Imperator("test", loadedProperty));
    }


}
