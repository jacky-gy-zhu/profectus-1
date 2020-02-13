package com.profectus.fishshop.visitor;

import com.profectus.fishshop.iterator.Aggregate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonStructure implements Aggregate<Person> {

    private List<Person> list;

    public PersonStructure() {
        list = new ArrayList<>();
    }

    @Override
    public void add(Person person) {
        list.add(person);
    }

    public void remove(Person person) {
        list.remove(person);
    }

    public void performAll(Action action) {
        list.forEach(p -> p.accept(action));
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator<Person>();
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
