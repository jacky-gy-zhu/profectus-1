package com.profectus.fishshop.visitor;

public class Student implements Person {

    @Override
    public void accept(Action action) {
        action.performStudent(this);
    }

    @Override
    public String getName() {
        return "Student";
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
