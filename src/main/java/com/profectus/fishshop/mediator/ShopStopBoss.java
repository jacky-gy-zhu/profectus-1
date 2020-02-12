package com.profectus.fishshop.mediator;

import com.profectus.fishshop.facade.Boss;

public class ShopStopBoss extends Action {

    public ShopStopBoss(Boss boss) {
        super(boss);
    }

    @Override
    public void execute() {
        Boss boss = (Boss) colleague;
        boss.close();
    }

}
