package com.profectus.fishshop.observer;

import java.util.Observable;

public abstract class ObservableItem extends Observable {

    protected float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price != this.price) {
            this.price = price;
            setChanged();
            notifyObservers();
        }
    }

}
