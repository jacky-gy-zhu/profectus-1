package com.profectus.fishshop.visitor;

public class FishFan implements Person {

    @Override
    public void accept(Action action) {
        action.performFishFan(this);
    }

    public void buy() {
        System.out.println("FishFan buy");
    }

    public void go() {
        System.out.println("FishFan go away");
    }

    public void see() {
        System.out.println("FishFan see");
    }

}
