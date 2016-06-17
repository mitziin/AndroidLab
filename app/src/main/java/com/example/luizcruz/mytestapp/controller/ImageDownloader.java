package com.example.luizcruz.mytestapp.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.luizcruz.mytestapp.R;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by luiz.cruz on 17/06/16.
 */
public class ImageDownloader extends AsyncTask<String, String, Bitmap> {

    private Bitmap mBitmap;
    private ImageView img;
    private View rootView;

    public ImageDownloader(View rootView){
        this.rootView = rootView;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        img = (ImageView) rootView.findViewById(R.id.productImg);
    }

    protected Bitmap doInBackground(String... args) {
        try {
            mBitmap = BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mBitmap;
    }

    protected void onPostExecute(Bitmap image) {

        if(image != null){
            img.setImageBitmap(image);
        }else{
            Toast.makeText(null, "Image Does Not exist or Network Error", Toast.LENGTH_SHORT).show();
        }
    }

}
