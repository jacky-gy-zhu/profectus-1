package com.profectus.fishshop.manager;

import com.profectus.fishshop.builder.FishBuilder;
import com.profectus.fishshop.fish.Fish;

import java.time.LocalDateTime;

public class Jessie extends FishShopManager {

    public Jessie(FishBuilder fishBuilder) {
        super(fishBuilder);
    }

    @Override
    protected String name() {
        return "Jessie";
    }

    @Override
    protected Fish build() {
        if (LocalDateTime.now().getSecond() % 2 != 0) {
            signature();
            return fishBuilder.build();
        } else {
            return nextFishShopManager.buildFish();
        }
    }

}
