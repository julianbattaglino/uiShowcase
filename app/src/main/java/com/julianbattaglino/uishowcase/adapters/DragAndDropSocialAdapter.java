package com.julianbattaglino.uishowcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.model.DummyModel;
import com.julianbattaglino.uishowcase.utils.ImageUtil;
import com.nhaarman.listviewanimations.util.Swappable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Julian Battaglino.
 */

public class DragAndDropSocialAdapter extends BaseAdapter implements Swappable {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<DummyModel> mDummyModelList;

    public DragAndDropSocialAdapter(Context context,
                                    ArrayList<DummyModel> dummyModelList) {
        mContext = context;
        mInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDummyModelList = dummyModelList;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public int getCount() {
        return mDummyModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDummyModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mDummyModelList.get(position).getId();
    }

    @Override
    public void swapItems(int positionOne, int positionTwo) {
        Collections.swap(mDummyModelList, positionOne, positionTwo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(
                    R.layout.list_item_drag_and_drop_social, parent, false);
            holder = new ViewHolder();
            holder.image = convertView
                    .findViewById(R.id.item_drag_and_drop_social_image);
            holder.text = convertView
                    .findViewById(R.id.item_drag_and_drop_social_name);
            holder.place = convertView
                    .findViewById(R.id.item_drag_and_drop_social_place);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DummyModel dm = mDummyModelList.get(position);

        ImageUtil.displayRoundImage(holder.image, dm.getImageURL(), null);
        holder.text.setText(dm.getText());
        return convertView;
    }

    private static class ViewHolder {
        public ImageView image;
        public/* Roboto */ TextView text;
        public/* Roboto */ TextView subtext;
        public/* Fontello */ TextView icon;
        public/* Roboto */ TextView rating;
        public/* Roboto */ TextView place;
    }
}
