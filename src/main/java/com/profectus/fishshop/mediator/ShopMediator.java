package com.profectus.fishshop.mediator;

import com.profectus.fishshop.mediator.factory.ShopActionFactory;
import com.profectus.fishshop.mediator.factory.ShopFactory;

public class ShopMediator extends Mediator {

    @Override
    public void operation(Message action) {
        ShopFactory shopFactory = new ShopFactory();
        ShopActionFactory shopActionFactory = shopFactory.createActionFactory(action);
        colleagues
                .forEach(c -> {

                    Action shop = shopActionFactory.createShop(c);
                    shop.execute();

                });

    }

}
