package com.profectus.fishshop.visitor;

public class Worker implements Person {

    @Override
    public void accept(Action action) {
        action.performWorker(this);
    }

    public void buy() {
        System.out.println("Worker buy");
    }

    public void go() {
        System.out.println("Worker go away");
    }

    public void see() {
        System.out.println("Worker see");
    }

}
