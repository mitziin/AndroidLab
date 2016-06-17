package com.example.luizcruz.mytestapp.net.model;

/**
 * Created by guilherme on 20/05/16.
 */
public class Offer {

    private String id;
    private Double listPrice;
    private Double salesPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(Double salePrice) {
        this.salesPrice = salePrice;
    }
}
