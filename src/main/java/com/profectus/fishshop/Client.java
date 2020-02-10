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
import com.profectus.fishshop.state.Activity;
import com.profectus.fishshop.visitor.*;

import java.util.Iterator;
import java.util.stream.IntStream;

public class Client {

    public static void main(String[] args) {
        observer();
        facade();
        mediator();
        command();
        state();
        visitor();
        iterator();
    }

    public static void observer() {
        System.out.println("---------observer()---------");
        Sales sales = new Sales(null);
        sales.quote();

        Big big = new Big();

        // add observer (Observer Pattern)
        sales.attach(big);

        big.setPrice(12);
    }

    public static void facade() {
        System.out.println("---------facade()---------");
        // facade
        ShopFacade shopFacade = new ShopFacade();
        shopFacade.open();
    }

    public static void mediator() {
        System.out.println("---------mediator()---------");
        Mediator mediator = new ShopMediator();
//        Mediator mediator = new ChatMediator();
        Colleague boss = new Boss(mediator);
        Colleague sales = new Sales(mediator);

        mediator.registerColleague(boss);
        mediator.registerColleague(sales);

        boss.sendMessage(Mediator.Message.START);
    }

    public static void command(){
        System.out.println("---------command()---------");
        Boss boss = new Boss(null);
        Sales sales = new Sales(null);

        Command openCommand = new OpenCommand(boss, sales);
        Command closeCommand = new CloseCommand(boss, sales);

        Government government = new Government(openCommand, closeCommand);

        government.open();
        government.close();
    }

    public static void state() {
        System.out.println("---------state()---------");
        Activity activity = new Activity();

        IntStream.range(0,10)
                .forEach(n -> activity.action(n));

    }

    public static void visitor() {
        System.out.println("---------visitor()---------");
        Person worker = new Worker();
        Person student = new Student();
        Person fishFan = new FishFan();
        // show people who will purchase
        PersonStructure structure = new PersonStructure();
        structure.add(fishFan); // add people
        structure.add(student);
        Action action = new PurchaseAction(); //act purchase
        structure.performAll(action); // show results

        // show people who will watch
        structure = new PersonStructure();
        structure.add(student); // add people
        action = new WatchAction(); //act watch
        structure.performAll(action); // show results

        // show people who will go away
        structure = new PersonStructure();
        structure.add(worker); // add people
        action = new WalkAwayAction(); //act go away
        structure.performAll(action); // show results
    }

    public static void iterator() {
        System.out.println("---------iterator()---------");
        Person worker = new Worker();
        Person student = new Student();
        Person fishFan = new FishFan();
        PersonStructure structure = new PersonStructure();
        structure.add(worker);
        structure.add(student);
        structure.add(fishFan);
        Iterator<Person> it = structure.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            System.out.println(person.getName());
        }
    }

}
