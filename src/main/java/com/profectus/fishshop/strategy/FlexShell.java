package com.profectus.fishshop.strategy;

import com.profectus.fishshop.decorator.Settlement;

public class FlexShell implements SellStrategy {

    @Override
    public String getName() {
        return "flex";
    }

    @Override
    public void sell(Settlement settlement) {
        System.out.println("strategy [" + getName() + "] selling...\n" + settlement.getDescription() + "\n" + settlement.getPrice());
    }

}
