package com.profectus.fishshop.facade;

import com.profectus.fishshop.observer.Sales;

public class ShopFacade {

    private Boss boss;
    private Sales sales;

    public ShopFacade() {
        boss = new Boss(null);
        sales = new Sales(null);
    }

    public void open() {
        boss.open();
        sales.quote();
    }

}
