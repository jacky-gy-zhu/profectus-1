package com.profectus.fishshop.size;

public class Small implements Size {

    @Override
    public float getPrice() {
        return 33;
    }

    @Override
    public String getDescription() {
        return "small size - " + getPrice();
    }

}
