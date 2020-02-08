package com.profectus.fishshop.decorator;

public class Stone extends SettlementDecorator {

    public Stone(Settlement settlement) {
        super(settlement);
        setPrice(30);
        setDescription("stone - " + price);
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
