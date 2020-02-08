package com.profectus.fishshop.market;

/**
 * Lazy initialization safely
 */
public class ZhMarketHandler {

    private static ZhMarketHandler zhMarketHandler;

    private ZhMarketHandler(){}

    public static ZhMarketHandler getInstance(){
        if (zhMarketHandler == null) {
            synchronized (ZhMarketHandler.class) {
                if (zhMarketHandler == null) {
                    zhMarketHandler = new ZhMarketHandler();
                }
            }
        }
        return zhMarketHandler;
    }

    public void proceed(ZhMarket zhMarket) {
        System.out.println("proceeding Zh Market price : "+zhMarket.getRmb());
    }

}
