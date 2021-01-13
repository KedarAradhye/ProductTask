package com.android.producttask.view.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.producttask.R;
import com.android.producttask.view.Activity.MainActivity;
import com.bumptech.glide.Glide;

public class BoughtAdapter extends RecyclerView.Adapter<BoughtAdapter.ViewHolder> {

    private Context mContext;

    public BoughtAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_bought_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mProductName.setText(R.string.product_name);
        holder.mAmount.setText(R.string.price);
        holder.mDiscount.setText(R.string.price_discount);
        holder.mDiscount.setPaintFlags(holder.mDiscount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        Glide.with(mContext).load(R.drawable.download1).into(holder.mProductImage);
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mAmount;
        public TextView mDiscount;
        public TextView mProductName;
        public Button mAddToCart;
        public ImageView mProductImage;

        public ViewHolder(View itemView) {
            super(itemView);
            mProductName = (TextView) itemView.findViewById(R.id.tv_product_name);
            mAmount = (TextView) itemView.findViewById(R.id.tv_price);
            mDiscount = (TextView) itemView.findViewById(R.id.tv_discount);
            mAddToCart =  itemView.findViewById(R.id.btn_add_to_cart);
            mProductImage =  itemView.findViewById(R.id.iv_product_image);

        }
    }

}
