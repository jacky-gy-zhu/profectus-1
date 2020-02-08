package com.profectus.fishshop.env;

public class Coldwater implements Env {

    @Override
    public float getPrice() {
        return 10;
    }

    @Override
    public String getDescription() {
        return "cold water env - " + getPrice();
    }

}
