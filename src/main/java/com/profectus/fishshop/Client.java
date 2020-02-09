package com.profectus.fishshop;

import com.profectus.fishshop.facade.ShopFacade;
import com.profectus.fishshop.observer.Sales;
import com.profectus.fishshop.size.Big;

public class Client {

    public static void main(String[] args) {
        observer();
        facade();
    }

    public static void observer() {
        Sales sales = new Sales();
        sales.quote();

        Big big = new Big();

        // add observer (Observer Pattern)
        sales.attach(big);

        big.setPrice(12);
    }

    public static void facade() {
        // facade
        ShopFacade shopFacade = new ShopFacade();
        shopFacade.open();
    }

}
