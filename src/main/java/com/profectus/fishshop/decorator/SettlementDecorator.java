package com.profectus.fishshop.decorator;

public abstract class SettlementDecorator implements Settlement {

    protected Settlement settlement;
    protected float price;
    protected String description;

    public SettlementDecorator(Settlement settlement) {
        this.settlement = settlement;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
