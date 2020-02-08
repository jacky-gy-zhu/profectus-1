package com.profectus.fishshop.market;

/**
 * Eager initialization
 */
public enum  EuMarketHandler {

    INSTANCE;

    public void proceed(EuMarket euMarket) {
        System.out.println("proceeding Eu Market price : "+euMarket.getPnd());
    }

}
