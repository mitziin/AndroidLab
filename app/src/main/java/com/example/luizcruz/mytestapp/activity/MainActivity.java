package com.example.luizcruz.mytestapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.luizcruz.mytestapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickProductListButton(View view){
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }



}
