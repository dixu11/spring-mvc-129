package com.mvc.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class MySessionConfig {

    @Bean
    @SessionScope
    public ImperatorSession createSession() {
        System.out.println("create!");
        return new ImperatorSession();
    }



}
