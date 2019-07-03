package com.julianbattaglino.uishowcase.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.utils.ImageUtil;
import com.nhaarman.listviewanimations.ArrayAdapter;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by Julian Battaglino.
 */

public class MyStickyListHeadersAdapter extends ArrayAdapter<String> implements StickyListHeadersAdapter {

    private final Context mContext;
    private LayoutInflater mInflater;

    public MyStickyListHeadersAdapter(final Context context) {
        mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < 1000; i++) {
            add("Row number " + i);
        }
    }

    @Override
    public long getItemId(final int position) {
        return getItem(position).hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_default, parent, false);
            holder = new ViewHolder();
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.icon = (TextView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //TODO Change image URL
        ImageUtil.displayRoundImage(holder.image, "", null);
        holder.text.setText(getItem(position));
        holder.icon.setText(R.string.fontello_heart_empty);
        return convertView;
    }

    @Override
    public View getHeaderView(final int position, final View convertView, final ViewGroup parent) {
        TextView view = (TextView) convertView;
        if (view == null) {
            view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.list_header, parent, false);
        }

        view.setText("Header " + getHeaderId(position));

        return view;
    }

    @Override
    public long getHeaderId(final int position) {
        return position / 10;
    }

    private static class ViewHolder {
        public ImageView image;
        public /*Roboto*/ TextView text;
        public /*Fontello*/ TextView icon;
    }
}
