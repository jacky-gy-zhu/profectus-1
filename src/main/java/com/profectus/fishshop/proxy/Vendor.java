package com.profectus.fishshop.proxy;

import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.market.AuMarket;

public class Vendor implements AuMarket {

    private Settlement settlement;
    private float extraFee;

    public Vendor(Settlement settlement, float extraFee) {
        this.settlement = settlement;
        this.extraFee = extraFee;
    }

    @Override
    public float getPrice() {
        return settlement.getPrice() + extraFee;
    }

}
