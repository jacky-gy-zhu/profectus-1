package com.profectus.fishshop.env;

public class Marine implements Env {

    @Override
    public float price() {
        return 30;
    }

    @Override
    public String description() {
        return "marine env";
    }

}
