package com.profectus.fishshop.decorator;

public class Plant extends SettlementDecorator {

    public Plant(Settlement settlement) {
        super(settlement);
        setPrice(10);
        setDescription("plant - " + price);
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
