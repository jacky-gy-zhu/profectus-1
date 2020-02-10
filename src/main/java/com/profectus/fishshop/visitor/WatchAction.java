package com.profectus.fishshop.visitor;

public class WatchAction extends Action {

    @Override
    public void performWorker(Worker worker) {
        worker.see();
    }

    @Override
    public void performStudent(Student student) {
        student.see();
    }

    @Override
    public void performFishFan(FishFan fishFan) {
        fishFan.see();
    }

}
