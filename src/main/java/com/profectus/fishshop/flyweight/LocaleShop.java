package com.profectus.fishshop.flyweight;

import com.profectus.fishshop.decorator.Settlement;

import java.util.Locale;

public class LocaleShop implements Shop {

    private Locale locale;

    public LocaleShop(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void sell(Settlement settlement) {
        System.out.println(locale.getDisplayCountry() + " selling...\n" + settlement.getDescription() + "\n" + settlement.getPrice());
    }

}
