package com.profectus.fishshop.mediator.factory;

import com.profectus.fishshop.mediator.Mediator;

public class ChatFactory {

    public ChatActionFactory createActionFactory(Mediator.Message message) {
        if (message == Mediator.Message.START) {
            return new ChatStartFactory();
        } else if (message == Mediator.Message.STOP) {
            return new ChatStopFactory();
        } else {
            return null;
        }
    }

}
