package com.profectus.fishshop.iterator;

import java.util.Iterator;

public interface Aggregate<T> {

    Iterator<T> iterator();

    void add(T t);

}
