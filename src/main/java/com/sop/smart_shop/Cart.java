package com.sop.smart_shop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<IceCream> orderInCart = new ArrayList<>();

    public static List<IceCream> currentOrder() {
        return orderInCart;
    }

    public static List<IceCream> addIceCream(int id, IceCream[] iceCreams) {
        for (IceCream iceCream: iceCreams) {
            if (iceCream.getId() == id) {
                orderInCart.add(iceCream);
            }
        }
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
        return orderInCart;
    }

    public static List<IceCream> clearIceCream() {
        orderInCart = new ArrayList<>();
        return null;
    }
}
