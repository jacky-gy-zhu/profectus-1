package com.profectus.fishshop.visitor;

public class FishFan implements Person {

    @Override
    public void accept(Action action) {
        action.performFishFan(this);
    }

    @Override
    public String getName() {
        return "FishFan";
    }

    public void buy() {
        System.out.println(getName() + " buy");
    }

    public void go() {
        System.out.println(getName() + " go away");
    }

    public void see() {
        System.out.println(getName() + " see");
    }

}
