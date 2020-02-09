package com.profectus.fishshop.composite;

public class Leaf implements Species {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFamilyTree() {
        return name;
    }
}
