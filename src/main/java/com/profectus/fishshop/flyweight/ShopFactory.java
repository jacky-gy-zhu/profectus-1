package com.profectus.fishshop.flyweight;

import com.profectus.fishshop.strategy.SellStrategy;

import java.util.HashMap;
import java.util.Map;

public class ShopFactory {

    private Map<String, Shop> shopMap = new HashMap<>();

    public Shop getShop(SellStrategy sellStrategy) {
        String strategyName = sellStrategy.getName();
        Shop shop = shopMap.get(strategyName);
        if (shop == null) {
            shop = new FishShop(sellStrategy);
            shopMap.put(strategyName, shop);
        }
        return shop;
    }

}
