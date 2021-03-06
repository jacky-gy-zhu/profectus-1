package com.profectus.fishshop.manager;

import com.profectus.fishshop.builder.FishBuilder;
import com.profectus.fishshop.fish.Fish;

public abstract class FishShopManager {

    protected FishBuilder fishBuilder;
    protected FishShopManager nextFishShopManager;

    public FishShopManager(FishBuilder fishBuilder) {
        this.fishBuilder = fishBuilder;
    }

    public void setNext(FishShopManager nextFishShopManager) {
        this.nextFishShopManager = nextFishShopManager;
    }

    protected abstract String name();

    protected abstract Fish build();

    protected void signature() {
        System.out.println(name()+" is building fish...");
    }

    public Fish buildFish(){
        return build();
    }

}
