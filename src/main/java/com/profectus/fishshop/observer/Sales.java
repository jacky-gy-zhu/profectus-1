package com.profectus.fishshop.observer;

import com.profectus.fishshop.adaptor.FishAdaptor;
import com.profectus.fishshop.builder.ColdBlueBigFishBuilder;
import com.profectus.fishshop.builder.FishBuilder;
import com.profectus.fishshop.builder.MarineGreenSmallFishBuilder;
import com.profectus.fishshop.decorator.Plant;
import com.profectus.fishshop.decorator.Pump;
import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.decorator.Stone;
import com.profectus.fishshop.factory.MelFactory;
import com.profectus.fishshop.factory.WorldFactory;
import com.profectus.fishshop.fish.BottomSwimFish;
import com.profectus.fishshop.fish.Fish;
import com.profectus.fishshop.fish.TopSwimFish;
import com.profectus.fishshop.flyweight.Shop;
import com.profectus.fishshop.flyweight.ShopFlyweightFactory;
import com.profectus.fishshop.manager.FishShopManager;
import com.profectus.fishshop.manager.Jacky;
import com.profectus.fishshop.manager.Jessie;
import com.profectus.fishshop.market.*;
import com.profectus.fishshop.mediator.Colleague;
import com.profectus.fishshop.mediator.Mediator;
import com.profectus.fishshop.strategy.SellStrategy;
import com.profectus.fishshop.strategy.SolidSell;

import com.profectus.fishshop.mediator.Mediator.Message;

import java.util.Observable;
import java.util.Observer;

public class Sales extends Colleague implements Observer {

    public Sales(Mediator mediator) {
        super(mediator);
    }

    // add observer
    public void attach(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        ObservableItem observableItem = (ObservableItem) o;
        System.out.println(observableItem.getClass().getSimpleName() + " price changed : " + observableItem.getPrice());
    }

    public void quote() {

        // init fish
        Fish topSwimFish = new TopSwimFish();
        Fish bottomSwimFish = new BottomSwimFish();

        // fish builder
        FishBuilder fishBuilder = new ColdBlueBigFishBuilder(topSwimFish);
        FishBuilder fishBuilder2 = new MarineGreenSmallFishBuilder(bottomSwimFish);

        // builder director
        FishShopManager jackyManager = new Jacky(fishBuilder);
        FishShopManager jessieManager = new Jessie(fishBuilder2);

        // chain of responsibility for manager
        jackyManager.setNext(jessieManager);
        jessieManager.setNext(jackyManager);

        // build fish reality
        Fish fish = jessieManager.buildFish();

        // how fish swim
        fish.swim();

        // clone fish
        //Fish cloneFish = fish.clone(); // shallow clone
        Fish cloneFish = fish.deepClone(); // deep clone

        // decorator fish package
        Settlement settlement = new Plant(cloneFish);
        settlement = new Stone(settlement);
        settlement = new Pump(settlement);

        // shop flyweight
        ShopFlyweightFactory shopFactory = new ShopFlyweightFactory();
        // sell strategy
        SellStrategy sellStrategy = new SolidSell();
        Shop shop = shopFactory.getShop(sellStrategy);
        shop.sell(settlement);

        // vendor proxy price
        WorldFactory factory = new MelFactory();
        AuMarket market = factory.createVendor(settlement);

        // currency adaptor
        FishAdaptor fishAdaptor = new FishAdaptor(market);

        // adaptor to US market
        UsMarketHandler.getInstance().proceed(fishAdaptor);

        // adaptor to Zh market
        ZhMarketHandler.getInstance().proceed(fishAdaptor);

        // adaptor to In market
        InMarketHandler.getInstance().proceed(fishAdaptor);

        // adaptor to Ca market
        CaMarketHandler.getInstance().proceed(fishAdaptor);

        // adaptor to Eu market
        EuMarketHandler.INSTANCE.proceed(fishAdaptor);

    }

    public void introduce() {
        System.out.println("I'm a sales.");
    }

    public void goodBye() {
        System.out.println("Bye bye!");
    }

    public void close() {
        System.out.println("Sales close quote");
    }

    @Override
    public void sendMessage(Message message) {
        mediator.operation(message);
    }

}
