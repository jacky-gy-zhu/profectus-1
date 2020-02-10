package com.profectus.fishshop.visitor;

import java.util.ArrayList;
import java.util.List;

public class PersonStructure {

    List<Person> list;

    public PersonStructure() {
        list = new ArrayList<>();
    }

    public void attach(Person person) {
        list.add(person);
    }

    public void detach(Person person) {
        list.remove(person);
    }

    public void performAll(Action action) {
        list.stream()
                .forEach(p -> {
                    p.accept(action);
                });
    }

}
