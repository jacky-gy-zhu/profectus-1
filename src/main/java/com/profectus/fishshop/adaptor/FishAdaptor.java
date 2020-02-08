package com.profectus.fishshop.adaptor;

import com.profectus.fishshop.market.AuMarket;

public class FishAdaptor extends CurrencyAdaptor {

    private AuMarket auMarket;
    private float rate;

    public FishAdaptor(AuMarket auMarket, float rate) {
        this.auMarket = auMarket;
        this.rate = rate;
    }

    @Override
    public float getUsd() {
        return auMarket.getPrice() * rate;
    }

}
