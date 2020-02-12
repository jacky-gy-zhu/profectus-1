package com.profectus.fishshop.mediator;

import com.profectus.fishshop.facade.Boss;

public class ChatStartBoss extends Action {

    public ChatStartBoss(Colleague colleague) {
        super(colleague);
    }

    @Override
    public void execute() {
        Boss boss = (Boss)colleague;
        boss.talk();
    }

}
