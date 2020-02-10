package com.profectus.fishshop.visitor;

public class Student implements Person {

    @Override
    public void accept(Action action) {
        action.performStudent(this);
    }

    public void buy() {
        System.out.println("Student buy");
    }

    public void go() {
        System.out.println("Student go away");
    }

    public void see() {
        System.out.println("Student see");
    }

}
