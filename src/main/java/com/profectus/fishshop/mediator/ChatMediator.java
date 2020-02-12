package com.profectus.fishshop.mediator;

import com.profectus.fishshop.mediator.factory.ChatActionFactory;
import com.profectus.fishshop.mediator.factory.ChatFactory;

public class ChatMediator extends Mediator {

    @Override
    public void operation(Message message) {
        ChatFactory chatFactory = new ChatFactory();
        ChatActionFactory chatActionFactory = chatFactory.createActionFactory(message);
        colleagues
                .forEach(c -> {

                    Action action = chatActionFactory.createColleague(c);
                    action.execute();

                });

    }

}
