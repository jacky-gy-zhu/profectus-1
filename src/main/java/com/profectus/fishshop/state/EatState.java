package com.profectus.fishshop.state;

public class EatState implements State {

    private Activity activity;

    public EatState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void action() {
        System.out.println("I'm eating...");
        activity.setState(activity.getHappyState());
    }

}
