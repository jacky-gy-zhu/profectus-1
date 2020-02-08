package com.profectus.fishshop.market;

/**
 * Eager initialization with static block
 */
public class InMarketHandler {

    private final static InMarketHandler usMarketHandler;

    private InMarketHandler(){}

    static {
        try {
            usMarketHandler = new InMarketHandler();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance");
        }
    }

    public static InMarketHandler getInstance(){
        return usMarketHandler;
    }

    public void proceed(InMarket inMarket) {
        System.out.println("proceeding In Market price : "+inMarket.getIna());
    }

}
