package com.profectus.fishshop.color;

public class Green implements Color {

    @Override
    public float getPrice() {
        return 4;
    }

    @Override
    public String getDescription() {
        return "Green color - " + getPrice();
    }

}
