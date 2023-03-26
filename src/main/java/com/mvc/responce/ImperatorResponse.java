package com.mvc.responce;

public class ImperatorResponse {
    private String name;
    private int credits;


    public ImperatorResponse(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }
}
