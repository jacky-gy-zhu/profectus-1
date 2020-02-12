package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.mediator.Action;
import com.profectus.fishshop.mediator.ChatStopBoss;
import com.profectus.fishshop.mediator.ChatStopSales;
import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.observer.Sales;

public class ChatStopFactory extends ChatActionFactory {

    @Override
    public Action createColleague(Colleague colleague) {
        if (colleague instanceof Boss) {
            return new ChatStopBoss(colleague);
        } else if (colleague instanceof Sales) {
            return new ChatStopSales(colleague);
        } else {
            return null;
        }
    }

}
