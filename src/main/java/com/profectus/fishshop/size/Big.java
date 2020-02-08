package com.profectus.fishshop.size;

public class Big implements Size {

    @Override
    public float price() {
        return 55;
    }

    @Override
    public String description() {
        return "big size";
    }

}
