package com.sop.smart_shop;

import java.util.List;

public class IceCreamOrder {
    private IceCreamOrder() {

    }
    private static IceCreamOrder INSTANCE;

    public static IceCreamOrder getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new IceCreamOrder();
        }
        return INSTANCE;
    }


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

    public List<IceCream> myOrder() {
        return Cart.currentOrder();
    }

    public List<IceCream> orderIceCream(int id){
        return Cart.addIceCream(id, menu);
    }
    public List<IceCream> cancelIceCream(int id){
        return Cart.deleteIceCream(id);
    }
}
