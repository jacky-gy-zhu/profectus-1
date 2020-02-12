package com.profectus.fishshop.mediator;

import com.profectus.fishshop.observer.Sales;

public class ShopStopSales extends Action {

    public ShopStopSales(Sales sales) {
        super(sales);
    }

    @Override
    public void execute() {
        Sales sales = (Sales) colleague;
        sales.close();
    }

}
