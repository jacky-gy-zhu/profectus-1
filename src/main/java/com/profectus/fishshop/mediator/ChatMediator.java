package com.profectus.fishshop.mediator;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.observer.Sales;

public class ChatMediator extends Mediator {

    @Override
    public void operation(Message message) {
        colleagues.stream()
                .forEach(c -> {
                    if (c instanceof Boss) {
                        Boss boss = ((Boss) c);
                        if (message == Message.START) {
                            boss.talk();
                        } else if (message == Message.STOP) {
                            boss.farewell();
                        }
                    } else if (c instanceof Sales) {
                        Sales sales = (Sales)c;
                        if (message == Message.START) {
                            sales.introduce();
                        } else if (message == Message.STOP) {
                            sales.goodBye();
                        }
                    }
                });

    }

}
