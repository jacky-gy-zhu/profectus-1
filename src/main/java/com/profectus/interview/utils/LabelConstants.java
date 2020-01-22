package com.profectus.interview.utils;

public enum LabelConstants implements EnumFace {

    NONE("", 0),

    SALES("Sales", 101),
    MERCHANDISE("Merchandise", 102);

    private int value;
    private String name;

    LabelConstants(String name, int value) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getValue() {
        return value;
    }

}
