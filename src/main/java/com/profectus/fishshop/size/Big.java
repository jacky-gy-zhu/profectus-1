package com.profectus.fishshop.size;

public class Big implements Size {

    @Override
    public float getPrice() {
        return 55;
    }

    @Override
    public String getDescription() {
        return "big size - " + getPrice();
    }

}
