package com.profectus.fishshop.mediator;

import com.profectus.fishshop.observer.Sales;

public class ChatStopSales extends Action {

    public ChatStopSales(Colleague colleague) {
        super(colleague);
    }

    @Override
    public void execute() {
        Sales sales = (Sales)colleague;
        sales.goodBye();
    }

}
