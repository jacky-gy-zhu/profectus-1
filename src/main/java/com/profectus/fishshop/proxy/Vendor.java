package com.profectus.fishshop.proxy;

import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.market.AuMarket;

public abstract class Vendor implements AuMarket {

    private Settlement settlement;

    public Vendor(Settlement settlement) {
        this.settlement = settlement;
    }

    protected abstract float extraFee();

    @Override
    public float getPrice() {
        return settlement.getPrice() + extraFee();
    }

}
