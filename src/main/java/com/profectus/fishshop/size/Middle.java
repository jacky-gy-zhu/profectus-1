package com.profectus.fishshop.size;

public class Middle implements Size {

    @Override
    public float getPrice() {
        return 44;
    }

    @Override
    public String getDescription() {
        return "middle size - " + getPrice();
    }

}
