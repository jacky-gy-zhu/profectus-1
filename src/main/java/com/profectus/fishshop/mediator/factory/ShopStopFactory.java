package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.mediator.Action;
import com.profectus.fishshop.mediator.ShopStopBoss;
import com.profectus.fishshop.mediator.ShopStopSales;
import com.profectus.fishshop.observer.Sales;

public class ShopStopFactory extends ShopActionFactory {

    @Override
    public Action createShop(Colleague colleague) {
        if (colleague instanceof Boss) {
            return new ShopStopBoss((Boss) colleague);
        } else if (colleague instanceof Sales) {
            return new ShopStopSales((Sales) colleague);
        } else {
            return null;
        }
    }

}
