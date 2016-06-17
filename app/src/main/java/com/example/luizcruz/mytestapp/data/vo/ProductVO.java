package com.example.luizcruz.mytestapp.data.vo;

import java.math.BigDecimal;

/**
 * Created by luiz.cruz on 16/06/16.
 */
public class ProductVO implements ViewObject {

    public String name;
    public BigDecimal priceFrom;
    public BigDecimal priceTo;
    public String imageUrl;

    public ProductVO(String name, BigDecimal priceFrom, BigDecimal priceTo, String imageUrl) {
        this.name = name;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.imageUrl = imageUrl;
    }
}
