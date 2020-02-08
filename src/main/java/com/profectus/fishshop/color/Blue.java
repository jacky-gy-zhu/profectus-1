package com.profectus.fishshop.color;

public class Blue implements Color {

    @Override
    public float getPrice() {
        return 5;
    }

    @Override
    public String getDescription() {
        return "Blue color - " + getPrice();
    }

}
