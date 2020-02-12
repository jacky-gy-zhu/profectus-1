package com.profectus.fishshop.mediator;

import com.profectus.fishshop.facade.Boss;

public class ShopStartBoss extends Action {

    public ShopStartBoss(Boss boss) {
        super(boss);
    }

    @Override
    public void execute() {
        Boss boss = (Boss) colleague;
        boss.open();
    }

}
