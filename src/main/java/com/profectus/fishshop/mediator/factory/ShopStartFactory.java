package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.mediator.Action;
import com.profectus.fishshop.mediator.ShopStartBoss;
import com.profectus.fishshop.mediator.ShopStartSales;
import com.profectus.fishshop.observer.Sales;

public class ShopStartFactory extends ShopActionFactory {

    @Override
    public Action createShop(Colleague colleague) {
        if (colleague instanceof Boss) {
            return new ShopStartBoss((Boss) colleague);
        } else if (colleague instanceof Sales) {
            return new ShopStartSales((Sales) colleague);
        } else {
            return null;
        }
    }

}
