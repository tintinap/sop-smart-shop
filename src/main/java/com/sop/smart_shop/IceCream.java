package com.sop.smart_shop;

import java.io.Serializable;

public class IceCream implements Serializable {
    private int id;
    private String flavor;
    private Double price;
    private String packaging;

    public IceCream(int id, String flavor, Double price, String packaging) {
        this.id = id;
        this.flavor = flavor;
        this.price = price;
        this.packaging = packaging;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPackaging() {
        return packaging;
    }

    public void setPackaging(String packaging) {
        this.packaging = packaging;
    }
}
