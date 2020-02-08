package com.profectus.fishshop.env;

public class Tropical implements Env {

    @Override
    public float getPrice() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "tropical env - " + getPrice();
    }

}
