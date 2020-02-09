package com.profectus.fishshop;

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
import com.profectus.fishshop.flyweight.ShopFactory;
import com.profectus.fishshop.manager.FishShopManager;
import com.profectus.fishshop.manager.Jacky;
import com.profectus.fishshop.manager.Jessie;
import com.profectus.fishshop.market.*;
import com.profectus.fishshop.strategy.SellStrategy;
import com.profectus.fishshop.strategy.SolidSell;

import java.util.Locale;

public class Client {

    public static void main(String[] args) {

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

        // shop sell (flyweight)
        ShopFactory shopFactory = new ShopFactory();
        // sell strategy
        SellStrategy sellStrategy = new SolidSell();
        Shop shop = shopFactory.getShop(sellStrategy);
        shop.sell(settlement);

        // vendor proxy price
        WorldFactory factory = new MelFactory();
        AuMarket market = factory.createVendor(settlement);
        System.out.println("market price : "+market.getPrice());

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

}
