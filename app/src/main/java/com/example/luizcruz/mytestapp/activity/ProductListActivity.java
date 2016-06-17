package com.example.luizcruz.mytestapp.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.luizcruz.mytestapp.R;
import com.example.luizcruz.mytestapp.SimpleDividerItemDecoration;
import com.example.luizcruz.mytestapp.data.ProductListAdapter;
import com.example.luizcruz.mytestapp.data.vo.ProductVO;
import com.example.luizcruz.mytestapp.net.model.Product;
import com.example.luizcruz.mytestapp.net.model.ProductList;
import com.example.luizcruz.mytestapp.service.B2WProductService;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductListActivity extends Activity {

    public RecyclerView mProductListView;
    public RecyclerView.Adapter mProductListAdapter;
    public RecyclerView.LayoutManager mProdutListLayoutManager;

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


        new TestDownloadRetrofit(this).execute();

        // specify an adapter (see also next example)

    }

    public void updateDataset(List<ProductVO> productVOs){
        mProductListAdapter = new ProductListAdapter(productVOs);
        mProductListView.setAdapter(mProductListAdapter);
        mProductListAdapter.notifyDataSetChanged();
    }



    public class TestDownloadRetrofit extends AsyncTask<String, String, ProductList>{


        private ProductListActivity activity;

        public TestDownloadRetrofit(ProductListActivity activity) {
            this.activity = activity;
        }


        @Override
        protected ProductList doInBackground(String... params) {

            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.americanas.com.br/v3/")
                    .build();

            B2WProductService productService = retrofit
                    .create(B2WProductService.class);

            Map<String,String> query = new HashMap<String, String>();

            query.put("limit", "30");
            query.put("q", "category.id:226762");

            Call<ProductList> list = productService.getProducts(query);

            ProductList productList = null;

            try{
                productList =  list.execute().body();
            } catch (Exception ex){
                Log.d("DEU RUIM", "DEU RUIM", ex);
                ex.printStackTrace();
            }

            return productList;
        }


        @Override
        protected void onPostExecute(ProductList productList) {
            super.onPostExecute(productList);

            List<ProductVO> list = new ArrayList<>();

            for (Product product: productList.getProducts()){


                String url = product.getImages().get(0).getMedium();


                list.add(new ProductVO(product.getName(),
                        BigDecimal.valueOf(10l),
                        BigDecimal.valueOf(10l),
                         url));
            }

            activity.updateDataset(list);

        }
    }

//    private List<ProductVO> getDummyDataset(){
//
//        List<ProductVO> testProducts = new ArrayList<>();
//
//        for (int index = 1; index < 101; index++) {
//            testProducts.add(new ProductVO("Produto " + index,
//                                            BigDecimal.valueOf(50),
//                                            BigDecimal.valueOf(50)));
//        }
//
//        return testProducts;
//    }


}
