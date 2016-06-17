package com.example.luizcruz.mytestapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.luizcruz.mytestapp.R;
import com.example.luizcruz.mytestapp.SimpleDividerItemDecoration;
import com.example.luizcruz.mytestapp.data.ProductListAdapter;
import com.example.luizcruz.mytestapp.data.vo.ProductVO;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductListActivity extends Activity {

    private RecyclerView mProductListView;
    private RecyclerView.Adapter mProductListAdapter;
    private RecyclerView.LayoutManager mProdutListLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mProductListView = (RecyclerView) findViewById(R.id.product_list_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mProductListView.setHasFixedSize(true);

        // use a linear layout manager
        mProdutListLayoutManager = new LinearLayoutManager(this);
        mProductListView.setLayoutManager(mProdutListLayoutManager);

        //
        mProductListView.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));

        // specify an adapter (see also next example)
        mProductListAdapter = new ProductListAdapter(getDummyDataset());
        mProductListView.setAdapter(mProductListAdapter);
    }


    private List<ProductVO> getDummyDataset(){
        List<ProductVO> testProducts = new ArrayList<>();

        for (int index = 1; index < 101; index++) {
            testProducts.add(new ProductVO("Produto " + index,
                                            BigDecimal.valueOf(50),
                                            BigDecimal.valueOf(50)));
        }

        return testProducts;
    }


}
