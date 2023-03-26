package com.mvc.session;


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
