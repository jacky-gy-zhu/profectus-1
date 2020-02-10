package com.profectus.fishshop.visitor;

public class WalkAwayAction extends Action {

    @Override
    public void performWorker(Worker worker) {
        worker.go();
    }

    @Override
    public void performStudent(Student student) {
        student.go();
    }

    @Override
    public void performFishFan(FishFan fishFan) {
        fishFan.go();
    }

}
