package com.profectus.fishshop.visitor;

public class PurchaseAction extends Action {

    @Override
    public void performWorker(Worker worker) {
        worker.buy();
    }

    @Override
    public void performStudent(Student student) {
        student.buy();
    }

    @Override
    public void performFishFan(FishFan fishFan) {
        fishFan.buy();
    }

}
