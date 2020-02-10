package com.profectus.fishshop.state;

public class Activity {

    private State state;
    private State hungryState;
    private State eatState;
    private State happyState;
    private State swimState;

    public Activity() {
        hungryState = new HungryState(this);
        eatState = new EatState(this);
        happyState = new HappyState(this);
        swimState = new SwimState(this);
        // init first state
        setState(hungryState);
    }

    public State getHungryState() {
        return hungryState;
    }

    public State getEatState() {
        return eatState;
    }

    public State getHappyState() {
        return happyState;
    }

    public State getSwimState() {
        return swimState;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void action(int count) {
        System.out.println(count);
        state.action();
    }

}
