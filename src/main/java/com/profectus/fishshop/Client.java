package com.profectus.fishshop;

import com.profectus.fishshop.builder.ColdBlueBigFishBuilder;
import com.profectus.fishshop.builder.FishBuilder;
import com.profectus.fishshop.builder.MarineGreenSmallFishBuilder;
import com.profectus.fishshop.fish.BottomSwimFish;
import com.profectus.fishshop.fish.Fish;
import com.profectus.fishshop.fish.TopSwimFish;
import com.profectus.fishshop.manager.FishShopManager;
import com.profectus.fishshop.manager.Jacky;
import com.profectus.fishshop.manager.Jessie;

public class Client {

    public static void main(String[] args) {
        Fish topSwimFish = new TopSwimFish();
        Fish bottomSwimFish = new BottomSwimFish();
        FishBuilder fishBuilder = new ColdBlueBigFishBuilder(topSwimFish);
        FishBuilder fishBuilder2 = new MarineGreenSmallFishBuilder(bottomSwimFish);
        FishShopManager jackyManager = new Jacky(fishBuilder);
        FishShopManager jessieManager = new Jessie(fishBuilder2);

        jackyManager.setNext(jessieManager);
        jessieManager.setNext(jackyManager);

        Fish fish = jessieManager.buildFish();

        System.out.println(fish.getDescription());
        System.out.println(fish.getPrice());

    }

}
