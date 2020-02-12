package com.profectus.fishshop.mediator;

public abstract class Action {

    protected Colleague colleague;

    public Action(Colleague colleague) {
        this.colleague = colleague;
    }

    public abstract void execute();

}
