package com.profectus.fishshop.env;

public class Marine implements Env {

    @Override
    public float getPrice() {
        return 30;
    }

    @Override
    public String getDescription() {
        return "marine env - " + getPrice();
    }

}
