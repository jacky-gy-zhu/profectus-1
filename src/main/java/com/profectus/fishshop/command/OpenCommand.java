package com.profectus.fishshop.command;

import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.observer.Sales;

public class OpenCommand implements Command {

    private Boss boss;
    private Sales sales;

    public OpenCommand(Boss boss, Sales sales) {
        this.boss = boss;
        this.sales = sales;
    }

    @Override
    public void execute() {
        boss.open();
        sales.quote();
    }

}
