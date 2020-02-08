package com.profectus.fishshop.decorator;

import com.profectus.fishshop.market.AuMarket;

public interface Settlement extends AuMarket {

    float getPrice();

    String getDescription();

}
