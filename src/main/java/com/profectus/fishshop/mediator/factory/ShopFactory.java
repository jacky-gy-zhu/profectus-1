package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.mediator.Mediator;

public class ShopFactory {

    public ShopActionFactory createActionFactory(Mediator.Message action) {
        if (action == Mediator.Message.START) {
            return new ShopStartFactory();
        } else if (action == Mediator.Message.STOP) {
            return new ShopStopFactory();
        }else{
            return null;
        }
    }

}
