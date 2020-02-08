package com.profectus.fishshop.decorator;

public class Pump extends SettlementDecorator {

    public Pump(Settlement settlement) {
        super(settlement);
        setPrice(100);
        setDescription("pump - " + price);
    }

    @Override
    public float getPrice() {
        return settlement.getPrice() + price;
    }

    @Override
    public String getDescription() {
        return settlement.getDescription() + "\n" + description;
    }

}
