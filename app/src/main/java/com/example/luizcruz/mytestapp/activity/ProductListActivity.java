package com.example.luizcruz.mytestapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.luizcruz.mytestapp.R;
import com.example.luizcruz.mytestapp.data.ProductListAdapter;

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

        // specify an adapter (see also next example)
        mProductListAdapter = new ProductListAdapter(myDataset);
        mProductListView.setAdapter(mProductListAdapter);
    }
}
