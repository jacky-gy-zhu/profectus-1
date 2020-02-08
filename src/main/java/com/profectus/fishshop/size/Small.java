package com.profectus.fishshop.size;

public class Small implements Size {

    @Override
    public float price() {
        return 33;
    }

    @Override
    public String description() {
        return "small size";
    }

}
