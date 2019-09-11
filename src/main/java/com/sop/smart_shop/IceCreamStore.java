package com.sop.smart_shop;

public class IceCreamStore {
    private static IceCreamStore store;

    private IceCreamStore() {

    }
    public static IceCreamStore getInstance() {
        if (store != null) {
            return store;
        }
        return new IceCreamStore();
    }
}
