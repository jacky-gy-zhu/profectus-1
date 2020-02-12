package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.mediator.Action;
import com.profectus.fishshop.mediator.ChatStartBoss;
import com.profectus.fishshop.mediator.ChatStartSales;
import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.observer.Sales;

public class ChatStartFactory extends ChatActionFactory {

    @Override
    public Action createColleague(Colleague colleague) {
        if (colleague instanceof Boss) {
            return new ChatStartBoss(colleague);
        } else if (colleague instanceof Sales) {
            return new ChatStartSales(colleague);
        } else {
            return null;
        }
    }

}
