package com.profectus.fishshop.adaptor;

import com.profectus.fishshop.market.AuMarket;

public class FishAdaptor extends CurrencyAdaptor {

    private AuMarket auMarket;

    public FishAdaptor(AuMarket auMarket) {
        this.auMarket = auMarket;
    }

    @Override
    public float getUsd() {
        return auMarket.getPrice() * 0.76f;
    }

    @Override
    public float getRmb() {
        return auMarket.getPrice() * 1.2f;
    }

    @Override
    public float getIna() {
        return auMarket.getPrice() * 3.1f;
    }

    @Override
    public float getCad() {
        return auMarket.getPrice() * 0.8f;
    }

    @Override
    public float getPnd() {
        return auMarket.getPrice() * 0.2f;
    }
}
