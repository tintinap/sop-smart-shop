package com.sop.smart_shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Storage_manager SM = new Storage_manager();
    private static List<IceCream> orderInCart = SM.readOrderFile("order.dat");

    public static List<IceCream> currentOrder() {
        return orderInCart;
    }

    public static List<IceCream> addIceCream(int id, IceCream[] iceCreams) {
        for (IceCream iceCream: iceCreams) {
            if (iceCream.getId() == id) {
                orderInCart.add(iceCream);
            }
        }
        SM.writeOrderFile("order.dat", orderInCart);
        return orderInCart;
    }

    public static List<IceCream> deleteIceCream(int id) {
        int index = 0;
        for (IceCream iceCream : orderInCart) {
            if (iceCream.getId() == id) {
                index = orderInCart.indexOf(iceCream);
                orderInCart.remove(index);
            }
        }
        SM.writeOrderFile("order.dat", orderInCart);
        return orderInCart;
    }

    public static List<IceCream> clearIceCream() {
        orderInCart = new ArrayList<>();
        SM.writeOrderFile("order.dat", orderInCart);
        return orderInCart;
    }
}
