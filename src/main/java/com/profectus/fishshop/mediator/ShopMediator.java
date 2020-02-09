package com.profectus.fishshop.mediator;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.observer.Sales;

public class ShopMediator extends Mediator {

    @Override
    public void operation(Message message) {
        colleagues.stream()
                .forEach(c -> {
                    if (c instanceof Boss) {
                        Boss boss = ((Boss) c);
                        if (message == Message.START) {
                            boss.open();
                        } else if (message == Message.STOP) {
                            boss.close();
                        }
                    } else if (c instanceof Sales) {
                        Sales sales = (Sales)c;
                        if (message == Message.START) {
                            sales.quote();
                        } else if (message == Message.STOP) {
                            sales.close();
                        }
                    }
                });

    }

}
