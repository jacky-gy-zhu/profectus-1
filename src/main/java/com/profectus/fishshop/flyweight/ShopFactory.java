package com.profectus.fishshop.flyweight;

import java.util.Locale;
import java.util.Map;
import java.util.HashMap;

public class ShopFactory {

    private Map<Locale, Shop> shopMap = new HashMap<>();

    public Shop getShop(Locale locale) {
        Shop shop = shopMap.get(locale);
        if (shop == null) {
            shop = new LocaleShop(locale);
            shopMap.put(locale, shop);
        }
        return shop;
    }

}
