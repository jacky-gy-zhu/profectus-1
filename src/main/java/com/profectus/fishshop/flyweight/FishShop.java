package com.profectus.fishshop.flyweight;

import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.strategy.SellStrategy;

public class FishShop implements Shop {

    private SellStrategy sellStrategy;

    public FishShop(SellStrategy sellStrategy) {
        this.sellStrategy = sellStrategy;
    }

    @Override
    public void sell(Settlement settlement) {
        sellStrategy.sell(settlement);
    }

}
