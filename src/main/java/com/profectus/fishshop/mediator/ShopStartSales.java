package com.profectus.fishshop.mediator;

import com.profectus.fishshop.observer.Sales;

public class ShopStartSales extends Action {

    public ShopStartSales(Sales sales) {
        super(sales);
    }

    @Override
    public void execute() {
        Sales sales = (Sales)colleague;
        sales.introduce();
    }

}
