package com.profectus.fishshop.factory;

import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.proxy.MelVendor;
import com.profectus.fishshop.proxy.Vendor;

public class MelFactory extends WorldFactory {

    @Override
    public Vendor createVendor(Settlement settlement) {
        return new MelVendor(settlement);
    }

}
