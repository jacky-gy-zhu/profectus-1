package com.profectus.fishshop.env;

public class Coldwater implements Env {

    @Override
    public float price() {
        return 10;
    }

    @Override
    public String description() {
        return "cold water env";
    }

}
