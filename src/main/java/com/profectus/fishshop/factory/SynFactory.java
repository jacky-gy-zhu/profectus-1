package com.profectus.fishshop.factory;

import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.proxy.SynVendor;
import com.profectus.fishshop.proxy.Vendor;

public class SynFactory extends WorldFactory {

    @Override
    public Vendor createVendor(Settlement settlement) {
        return new SynVendor(settlement);
    }

}
