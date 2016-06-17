package com.example.luizcruz.mytestapp.net.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by guilherme on 20/05/16.
 */
public class ProductList {

    private List<Product> products = new LinkedList<Product>();

    private Map<String,String> _result;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Map<String,String> get_result() {
        return _result;
    }

    public void set_result(Map<String, String> _result) {
        this._result = _result;
    }

}
