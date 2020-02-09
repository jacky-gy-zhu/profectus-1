package com.profectus.fishshop.builder;

import com.profectus.fishshop.color.Blue;
import com.profectus.fishshop.composite.Composite;
import com.profectus.fishshop.composite.Leaf;
import com.profectus.fishshop.composite.Species;
import com.profectus.fishshop.env.Coldwater;
import com.profectus.fishshop.fish.Fish;
import com.profectus.fishshop.size.Big;

public class ColdBlueBigFishBuilder extends FishBuilder {

    public ColdBlueBigFishBuilder(Fish fish) {
        super(fish);
    }

    @Override
    public void buildEnv() {
        fish.setEnv(new Coldwater());
    }

    @Override
    public void buildColor() {
        fish.setColor(new Blue());
    }

    @Override
    protected void buildSpecies() {
        Composite cw = new Composite("cold water");
        Composite cl = new Composite("color");
        Species blue = new Leaf("blue");

        cw.add(cl);
        cl.add(blue);

        fish.setSpecies(cw);
    }

    @Override
    public void buildSize() {
        fish.setSize(new Big());
    }

}
