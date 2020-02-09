package com.profectus.fishshop.mediator;

import java.util.ArrayList;
import java.util.List;

public abstract class Mediator {

    protected List<Colleague> colleagues;

    public Mediator(){
        colleagues = new ArrayList<>();
    }

    public void registerColleague(Colleague colleague){
        colleagues.add(colleague);
    }

    public abstract void operation(Message message);

    public enum Message {
        START,
        STOP
    }

}
