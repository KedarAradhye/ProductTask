package com.android.producttask.view.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.producttask.R;
import com.android.producttask.view.Activity.MainActivity;
import com.android.producttask.view.Model.RatingReviewResponse;

import java.util.ArrayList;
import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ViewHolder> {

    private Context mContext;

    public RatingAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_rating_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName.setText(R.string.ajay_singh);
        holder.mDescription.setText(R.string.description_name);
    }

    @Override
    public int getItemCount() {
        return 2;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mName;
        public TextView mDescription;
        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.tv_name);
            mDescription = (TextView) itemView.findViewById(R.id.tv_description);
        }
    }
}
