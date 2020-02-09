package com.profectus.fishshop.strategy;

import com.profectus.fishshop.decorator.Settlement;

public interface SellStrategy {

    String getName();

    void sell(Settlement settlement);

}
