package com.profectus.fishshop.facade;

import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.mediator.Mediator;
import com.profectus.fishshop.mediator.Mediator.Message;

public class Boss extends Colleague {

    public Boss(Mediator mediator) {
        super(mediator);
    }

    public void open() {
        System.out.println("Boss open fish shop");
    }

    public void close() {
        System.out.println("Boss close fish shop");
    }

    public void talk() {
        System.out.println("I'm a boss.");
    }

    public void farewell() {
        System.out.println("See you!");
    }

    @Override
    public void sendMessage(Message message) {
        mediator.operation(message);
    }

}
