package com.profectus.fishshop.visitor;

public interface Person {

    void accept(Action action);

    String getName();

}
