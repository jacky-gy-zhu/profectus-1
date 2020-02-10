package com.profectus.fishshop.visitor;

import com.profectus.fishshop.iterator.Aggregate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonStructure implements Aggregate<T> {

    private List<T> list;

    public PersonStructure() {
        list = new ArrayList<>();
    }

    @Override
    public void add(T person) {
        list.add(person);
    }

    public void remove(T person) {
        list.remove(person);
    }

    public void performAll(Action action) {
        list.forEach(p -> p.accept(action));
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator<T>();
    }

    private class ConcreteIterator<T> implements Iterator<T> {

        int cursor;

        @Override
        public boolean hasNext() {
            return cursor != list.size();
        }

        @Override
        public T next() {
            if (cursor >= list.size()) {
                return null;
            } else {
                return (T) list.get(cursor++);
            }
        }

    }

}
