package com.sop.smart_shop;

public class IceCreamFactory {

    public static IceCream createIceCream(int id, String flavor, Double price, String packaging) {
        System.out.println("Ice cream!!!");
        IceCream ice = new IceCream(id, flavor, price, packaging);
        System.out.println(ice.getId() + " " + ice.getFlavor());
        return ice;
    }
}
