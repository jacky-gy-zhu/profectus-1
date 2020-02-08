package com.profectus.fishshop;

import com.profectus.fishshop.adaptor.FishAdaptor;
import com.profectus.fishshop.builder.ColdBlueBigFishBuilder;
import com.profectus.fishshop.builder.FishBuilder;
import com.profectus.fishshop.builder.MarineGreenSmallFishBuilder;
import com.profectus.fishshop.decorator.Plant;
import com.profectus.fishshop.decorator.Pump;
import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.decorator.Stone;
import com.profectus.fishshop.fish.BottomSwimFish;
import com.profectus.fishshop.fish.Fish;
import com.profectus.fishshop.fish.TopSwimFish;
import com.profectus.fishshop.manager.FishShopManager;
import com.profectus.fishshop.manager.Jacky;
import com.profectus.fishshop.manager.Jessie;
import com.profectus.fishshop.market.AuMarket;
import com.profectus.fishshop.market.UsMarketHandler;
import com.profectus.fishshop.proxy.Vendor;

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

        // decorator fish package
        Settlement settlement = new Plant(fish);
        settlement = new Stone(settlement);
        settlement = new Pump(settlement);

        // output package
        System.out.println(settlement.getDescription());
        System.out.println(settlement.getPrice());

        // vendor proxy price
        AuMarket market = new Vendor(settlement, 10);
        System.out.println("market price : "+market.getPrice());

        // adaptor to US market
        FishAdaptor fishAdaptor = new FishAdaptor(market, 1.2f);
        UsMarketHandler usMarketHandler = new UsMarketHandler();
        usMarketHandler.proceed(fishAdaptor);

    }

}
