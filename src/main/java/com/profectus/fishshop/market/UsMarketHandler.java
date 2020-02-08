package com.profectus.fishshop.market;

/**
 * Eager initialization
 */
public class UsMarketHandler {

    private final static UsMarketHandler usMarketHandler = new UsMarketHandler();

    private UsMarketHandler(){}

    public static UsMarketHandler getInstance(){
        return usMarketHandler;
    }

    public void proceed(UsMarket usMarket) {
        System.out.println("proceeding US Market price : "+usMarket.getUsd());
    }

}
