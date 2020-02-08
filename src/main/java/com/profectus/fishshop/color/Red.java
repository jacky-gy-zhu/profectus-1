package com.profectus.fishshop.color;

public class Red implements Color {

    @Override
    public float getPrice() {
        return 3;
    }

    @Override
    public String getDescription() {
        return "Red color - " + getPrice();
    }

}
