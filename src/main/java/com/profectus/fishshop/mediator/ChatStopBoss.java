package com.profectus.fishshop.mediator;

import com.profectus.fishshop.facade.Boss;

public class ChatStopBoss extends Action {

    public ChatStopBoss(Colleague colleague) {
        super(colleague);
    }

    @Override
    public void execute() {
        Boss boss = (Boss)colleague;
        boss.farewell();
    }

}
