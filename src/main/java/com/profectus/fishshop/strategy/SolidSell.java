package com.profectus.fishshop.strategy;

import com.profectus.fishshop.decorator.Settlement;

public class SolidSell implements SellStrategy {

    @Override
    public String getName() {
        return "solid";
    }

    @Override
    public void sell(Settlement settlement) {
        System.out.println("strategy ["+getName()+"] selling...\n" + settlement.getDescription() + "\n" + settlement.getPrice());
    }

}
