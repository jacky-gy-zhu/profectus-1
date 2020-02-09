package com.profectus.fishshop.factory;

import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.proxy.Vendor;

public abstract class WorldFactory {

    public abstract Vendor createVendor(Settlement settlement);

}
