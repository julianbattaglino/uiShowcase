package com.julianbattaglino.uishowcase.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.model.AndroidVersions;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Julian Battaglino.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    public onItemClickListener listener;
    private Context mContext;
    private List<AndroidVersions> mDataSet;

    public MainAdapter(Context context, List<AndroidVersions> dataSet) {
        mContext = context;
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_layout_home, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Picasso.with(mContext).load(mDataSet.get(position).getImage()).into(holder.image);
        holder.text.setText(mDataSet.get(position).getTitle());
        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position, holder.image, holder.text);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void remove(int position) {
        mDataSet.remove(position);
        notifyItemRemoved(position);
    }

    public void add(AndroidVersions obj, int position) {
        mDataSet.add(position, obj);
        notifyItemInserted(position);
    }

    public void setItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }


    public interface onItemClickListener {
        public void onItemClicked(int position, View v, TextView text);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;
        public TextView text;
        public View v;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.row_image);
            text = (TextView) itemView.findViewById(R.id.row_text);
            v = itemView;
        }
    }
}