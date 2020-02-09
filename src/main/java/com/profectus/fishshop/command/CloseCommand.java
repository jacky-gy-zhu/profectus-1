package com.profectus.fishshop.command;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.observer.Sales;

public class CloseCommand implements Command {

    private Boss boss;
    private Sales sales;

    public CloseCommand(Boss boss, Sales sales) {
        this.boss = boss;
        this.sales = sales;
    }

    @Override
    public void execute() {
        boss.close();
        sales.close();
    }

}
