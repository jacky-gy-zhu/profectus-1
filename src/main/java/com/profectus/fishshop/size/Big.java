package com.profectus.fishshop.size;

import com.profectus.fishshop.observer.ObservableItem;

public class Big extends ObservableItem implements Size {

    {
        super.price = 55;
    }

    @Override
    public String getDescription() {
        return "big size - " + getPrice();
    }

}
