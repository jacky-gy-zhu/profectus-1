package com.profectus.fishshop.size;

import com.profectus.fishshop.observer.ObservableItem;

public class Small extends ObservableItem implements Size {

    {
        super.price = 33;
    }

    @Override
    public String getDescription() {
        return "small size - " + getPrice();
    }

}
