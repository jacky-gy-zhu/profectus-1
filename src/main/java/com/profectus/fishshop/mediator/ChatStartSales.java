package com.profectus.fishshop.mediator;

import com.profectus.fishshop.observer.Sales;

public class ChatStartSales extends Action {

    public ChatStartSales(Colleague colleague) {
        super(colleague);
    }

    @Override
    public void execute() {
        Sales sales = (Sales)colleague;
        sales.introduce();
    }

}
