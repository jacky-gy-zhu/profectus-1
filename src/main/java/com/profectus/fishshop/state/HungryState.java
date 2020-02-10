package com.profectus.fishshop.state;

public class HungryState implements State {

    private Activity activity;

    public HungryState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void action() {
        System.out.println("I'm hungry");
        activity.setState(activity.getEatState());
    }

}
