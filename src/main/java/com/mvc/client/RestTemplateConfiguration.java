package com.mvc.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {
    @Bean  //dorzuca do puli beanów (spring context) narzędzie do robienia zapytań http
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
