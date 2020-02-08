package com.profectus.fishshop.builder;

import com.profectus.fishshop.color.Green;
import com.profectus.fishshop.env.Marine;
import com.profectus.fishshop.fish.Fish;
import com.profectus.fishshop.size.Small;

public class MarineGreenSmallFishBuilder extends FishBuilder {

    public MarineGreenSmallFishBuilder(Fish fish) {
        super(fish);
    }

    @Override
    public void buildEnv() {
        fish.setEnv(new Marine());
    }

    @Override
    public void buildColor() {
        fish.setColor(new Green());
    }

    @Override
    public void buildSize() {
        fish.setSize(new Small());
    }

}
