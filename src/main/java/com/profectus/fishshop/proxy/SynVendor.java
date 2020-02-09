package com.profectus.fishshop.proxy;

import com.profectus.fishshop.decorator.Settlement;

public class SynVendor extends Vendor {

    public SynVendor(Settlement settlement) {
        super(settlement);
        System.out.println("Sydney vendor");
    }

    @Override
    protected float extraFee() {
        return 20;
    }

}
