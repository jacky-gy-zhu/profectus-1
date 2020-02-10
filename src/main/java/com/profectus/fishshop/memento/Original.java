package com.profectus.fishshop.memento;

public class Original {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // save memento
    public Memento saveStateMemento() {
        return new Memento(state);
    }

    // restore from memento
    public void restoreState(Memento memento) {
        state = memento.getState();
    }

}
