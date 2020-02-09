package com.profectus.fishshop.mediator;

import com.profectus.fishshop.mediator.Mediator.Message;

public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage(Message message);

}
