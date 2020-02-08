package com.profectus.fishshop.env;

public class Tropical implements Env {

    @Override
    public float price() {
        return 20;
    }

    @Override
    public String description() {
        return "tropical env";
    }

}
