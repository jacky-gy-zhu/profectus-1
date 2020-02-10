package com.profectus.fishshop.visitor;

public class Worker implements T {

    @Override
    public void accept(Action action) {
        action.performWorker(this);
    }

    @Override
    public String getName() {
        return "Worker";
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
