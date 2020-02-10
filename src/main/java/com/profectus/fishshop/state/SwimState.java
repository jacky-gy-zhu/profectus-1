package com.profectus.fishshop.state;

public class SwimState implements State {

    private Activity activity;

    public SwimState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void action() {
        System.out.println("I'm swimming ~~~");
        activity.setState(activity.getHungryState());
    }

}
