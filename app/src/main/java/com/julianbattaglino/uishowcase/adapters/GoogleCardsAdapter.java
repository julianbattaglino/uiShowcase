package com.julianbattaglino.uishowcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.model.DummyModel;
import com.julianbattaglino.uishowcase.utils.ImageUtil;

import java.util.List;

/**
 * Created by Julian Battaglino.
 */

public class GoogleCardsAdapter extends ArrayAdapter<DummyModel> {

    private LayoutInflater mInflater;

    public GoogleCardsAdapter(Context context, List<DummyModel> items) {
        super(context, 0, items);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_google_cards, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        DummyModel item = getItem(position);
        ImageUtil.displayImage(holder.image, item.getImageURL(), null);

        return convertView;
    }

    private static class ViewHolder {
        public ImageView image;
    }
}

