package com.profectus.fishshop.market;

/**
 * Lazy initialization with static inner class
 */
public class CaMarketHandler {

    private CaMarketHandler(){}

    private static class Inner {
        private final static CaMarketHandler marketHandler = new CaMarketHandler();
    }

    public static CaMarketHandler getInstance(){
        return Inner.marketHandler;
    }

    public void proceed(CaMarket caMarket) {
        System.out.println("proceeding Ca Market price : "+caMarket.getCad());
    }

}
