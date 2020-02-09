package com.profectus.fishshop.proxy;

import com.profectus.fishshop.decorator.Settlement;

public class MelVendor extends Vendor {

    public MelVendor(Settlement settlement) {
        super(settlement);
        System.out.println("Melbourne vendor");
    }

    @Override
    protected float extraFee() {
        return 10;
    }

}
