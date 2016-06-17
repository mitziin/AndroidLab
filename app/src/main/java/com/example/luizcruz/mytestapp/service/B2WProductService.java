package com.example.luizcruz.mytestapp.service;

import com.example.luizcruz.mytestapp.net.model.ProductList;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by luiz.cruz on 17/06/16.
 */
public interface B2WProductService {

    @GET(value = "product" )
    Call<ProductList> getProducts(@QueryMap Map<String,String> queryParams);

}
