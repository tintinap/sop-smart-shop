package com.sop.smart_shop;

import java.util.List;

public class IceCreamOrder {

    private static IceCream[] menu =  {
            new IceCreamFactory().createIceCream(1, "Vanilla", 10.0, "cone"),
            new IceCreamFactory().createIceCream(2, "Chocolate", 11.0, "cone"),
            new IceCreamFactory().createIceCream(3, "Twisted", 11.0, "cone"),
    };

    public static IceCream[] getMenu() {
        System.out.println(menu[0].getId()+" "+menu[1].getId());
        System.out.println(menu.length);
        return menu;
    }

    public static List<IceCream> myOrder() {
        return Cart.currentOrder();
    }

    public static List<IceCream> orderIceCream(int id){
        return Cart.addIceCream(id, menu);
    }
    public static List<IceCream> cancelIceCream(int id){
        return Cart.deleteIceCream(id);
    }
}
