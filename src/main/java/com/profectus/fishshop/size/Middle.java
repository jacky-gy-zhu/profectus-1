package com.profectus.fishshop.size;

import com.profectus.fishshop.observer.ObservableItem;

public class Middle extends ObservableItem implements Size {

    {
        super.price = 44;
    }

    @Override
    public String getDescription() {
        return "middle size - " + getPrice();
    }

}
