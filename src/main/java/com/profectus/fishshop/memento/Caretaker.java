package com.profectus.fishshop.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {

    List<Memento> mementoList;

    public Caretaker() {
        mementoList = new ArrayList<>();
    }

    public void add(Memento memento) {
        mementoList.add(memento);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }

}
