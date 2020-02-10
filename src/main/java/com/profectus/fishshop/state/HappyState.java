package com.profectus.fishshop.state;

public class HappyState implements State {

    private Activity activity;

    public HappyState(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void action() {
        System.out.println("I feel happy!");
        activity.setState(activity.getSwimState());
    }

}
