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
        float price = fish.getEnv().getPrice() + fish.getColor().getPrice() + fish.getSize().getPrice();
        fish.setPrice(price);
    }

    public void buildDescription() {
        String description = fish.getEnv().getDescription() + "\n" + fish.getColor().getDescription() + "\n" + fish.getSize().getDescription();
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
