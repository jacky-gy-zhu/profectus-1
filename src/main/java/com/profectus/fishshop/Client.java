package com.profectus.fishshop;

import com.profectus.fishshop.command.CloseCommand;
import com.profectus.fishshop.command.Command;
import com.profectus.fishshop.command.Government;
import com.profectus.fishshop.command.OpenCommand;
import com.profectus.fishshop.facade.Boss;
import com.profectus.fishshop.facade.ShopFacade;
import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.mediator.Mediator;
import com.profectus.fishshop.mediator.ShopMediator;
import com.profectus.fishshop.observer.Sales;
import com.profectus.fishshop.size.Big;

public class Client {

    public static void main(String[] args) {
        observer();
        facade();
        mediator();
        command();
    }

    public static void observer() {
        Sales sales = new Sales(null);
        sales.quote();

        Big big = new Big();

        // add observer (Observer Pattern)
        sales.attach(big);

        big.setPrice(12);
    }

    public static void facade() {
        // facade
        ShopFacade shopFacade = new ShopFacade();
        shopFacade.open();
    }

    public static void mediator() {
        Mediator mediator = new ShopMediator();
//        Mediator mediator = new ChatMediator();
        Colleague boss = new Boss(mediator);
        Colleague sales = new Sales(mediator);

        mediator.registerColleague(boss);
        mediator.registerColleague(sales);

        boss.sendMessage(Mediator.Message.START);
    }

    public static void command(){
        Boss boss = new Boss(null);
        Sales sales = new Sales(null);

        Command openCommand = new OpenCommand(boss, sales);
        Command closeCommand = new CloseCommand(boss, sales);

        Government government = new Government(openCommand, closeCommand);

        government.open();
        government.close();
    }

}
