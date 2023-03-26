package com.mvc.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

public class ImperatorSession {
    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean notNamed() {
        return name.isEmpty();
    }




}
