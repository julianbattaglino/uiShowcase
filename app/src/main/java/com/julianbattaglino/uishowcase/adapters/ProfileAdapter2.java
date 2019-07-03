package com.julianbattaglino.uishowcase.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;

import java.util.ArrayList;

/**
 *
 */
public class ProfileAdapter2 extends RecyclerView.Adapter<ProfileAdapter2.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mDataSet;

    public ProfileAdapter2(Context context, ArrayList<String> dataSet) {
        mContext = context;
        this.mDataSet = dataSet;
    }

    public ProfileAdapter2(Context context) {
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_profile_2, null, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.text.setText(mDataSet.get(position));

        switch (position) {
            case 0:
                holder.image.setImageResource(R.drawable.macaw);
                break;
            case 1:
                holder.image.setImageResource(R.drawable.african_parrot);
                break;
            case 2:
                holder.image.setImageResource(R.drawable.cardinal);
                break;
            case 3:
                holder.image.setImageResource(R.drawable.duck);
                break;
            case 4:
                holder.image.setImageResource(R.drawable.eagle);
                break;
            case 5:
                holder.image.setImageResource(R.drawable.falcon);
                break;
            case 6:
                holder.image.setImageResource(R.drawable.pelican);
                break;
            default:
        }
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position >= 0 && position < getItemCount()) {
                    Toast.makeText(mContext, "Click on: " + mDataSet.get(position), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


    public void setItemClickListener(onItemClickListener listener) {
        //     this.listener = listener;
    }


    public interface onItemClickListener {
        void onItemClicked(int position, View v);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView text;
        public View v;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_row);
            text = itemView.findViewById(R.id.row_text);
            v = itemView;
        }
    }
}