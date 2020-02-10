package com.profectus.fishshop.visitor;

public abstract class Action {

    public abstract void performWorker(Worker worker);

    public abstract void performStudent(Student student);

    public abstract void performFishFan(FishFan fishFan);

}
