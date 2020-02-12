package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.mediator.Action;
import com.profectus.fishshop.mediator.Colleague;

public abstract class ChatActionFactory {

    public abstract Action createColleague(Colleague colleague);

}
