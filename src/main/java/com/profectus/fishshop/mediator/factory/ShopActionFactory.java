package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.mediator.Action;

public abstract class ShopActionFactory {

    public abstract Action createShop(Colleague colleague);

}
