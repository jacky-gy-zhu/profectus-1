package com.profectus.fishshop.builder;

import com.profectus.fishshop.fish.Fish;

public abstract class FishBuilder {

    protected Fish fish;

    public FishBuilder(Fish fish) {
        this.fish = fish;
    }

    protected abstract void buildEnv();

    protected abstract void buildColor();

    protected abstract void buildSize();

    public void buildPrice() {
        float price = fish.getEnv().price() + fish.getColor().price() + fish.getSize().price();
        fish.setPrice(price);
    }

    public void buildDescription() {
        String description = fish.getEnv().description() + "\n" + fish.getColor().description() + "\n" + fish.getSize().description();
        fish.setDescription(description);
    }

    public Fish build() {
        buildEnv();
        buildColor();
        buildSize();
        buildPrice();
        buildDescription();
        return fish;
    }

}
