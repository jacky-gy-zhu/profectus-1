package com.profectus.fishshop;

import com.profectus.fishshop.observer.Sales;
import com.profectus.fishshop.size.Big;

public class Client {

    public static void main(String[] args) {
        Sales sales = new Sales();
        sales.quote();

        Big big = new Big();

        // add observer (Observer Pattern)
        sales.attach(big);

        big.setPrice(12);
    }

}
