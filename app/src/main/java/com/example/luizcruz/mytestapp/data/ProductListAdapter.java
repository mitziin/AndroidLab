package com.example.luizcruz.mytestapp.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luizcruz.mytestapp.R;
import com.example.luizcruz.mytestapp.controller.ImageDownloader;
import com.example.luizcruz.mytestapp.data.vo.ProductVO;

import java.util.List;

/**
 * Created by luiz.cruz on 16/06/16.
 */
public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<ProductVO> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxtName, mTxtPriceFrom, mTxtPriceTo;
        public ImageView imgProductIcon;
        public String imgUrl;

        public ViewHolder(View v) {
            super(v);
            mTxtName = (TextView) v.findViewById(R.id.txtName);
            mTxtPriceFrom = (TextView) v.findViewById(R.id.txtPriceFrom);
            mTxtPriceTo = (TextView) v.findViewById(R.id.txtPriceTo);
            imgProductIcon = (ImageView) v.findViewById(R.id.productImg);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ProductListAdapter(List<ProductVO> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ProductListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_row, parent, false);

        // set the view's size, margins, paddings and layout parameters
        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ProductVO productVO = mDataset.get(position);
        holder.mTxtName.setText(productVO.name);
        holder.mTxtPriceFrom.setText( "R$ " + productVO.priceFrom.toString());
        holder.mTxtPriceTo.setText("R$ " + productVO.priceTo.toString());
        holder.imgUrl = productVO.imageUrl;

        new ImageDownloader(holder.imgProductIcon).execute(productVO.imageUrl);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
