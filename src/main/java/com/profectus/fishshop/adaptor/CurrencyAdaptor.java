package com.profectus.fishshop.adaptor;

import com.profectus.fishshop.market.UsMarket;

public abstract class CurrencyAdaptor implements UsMarket {

    @Override
    public float getUsd() {
        return 0;
    }

    @Override
    public void operate() {

    }

}
