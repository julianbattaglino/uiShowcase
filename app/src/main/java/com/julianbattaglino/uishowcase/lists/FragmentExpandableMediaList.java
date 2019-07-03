package com.julianbattaglino.uishowcase.lists;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.utils.ImageUtil;
import com.julianbattaglino.uishowcase.utils.customviews.AnimatedExpandableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian Battaglino.
 */

public class FragmentExpandableMediaList extends Fragment implements View.OnClickListener {

    private AnimatedExpandableListView listView;
    private ExampleAdapter adapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<GroupItem> items = new ArrayList<GroupItem>();
        items = fillData(items);

        adapter = new ExampleAdapter(getActivity());
        adapter.setData(items);

        listView = view.findViewById(R.id.list_view);
        listView.setDividerHeight(0);
        listView.setAdapter(adapter);

        // In order to show animations, we need to use a custom click handler
        // for our ExpandableListView.
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (listView.isGroupExpanded(groupPosition)) {
                    listView.collapseGroupWithAnimation(groupPosition);
                } else {
                    listView.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });

        // Set indicator (arrow) to the right
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                50, r.getDisplayMetrics());
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            listView.setIndicatorBounds(width - px, width);
        } else {
            listView.setIndicatorBoundsRelative(width - px, width);
        }
    }

    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            TextView tv = (TextView) v;
            Toast.makeText(getActivity(), tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    private List<GroupItem> fillData(List<GroupItem> items) {
        GroupItem item = new GroupItem();
        item.title = "Artist1";
        item.subtitle = "singer";
        item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
        ChildItem child;
        child = new ChildItem();
        child.title = "AlbumName1";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/10.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName2";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/11.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName3";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/12.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName4";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/13.jpg";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Artist2";
        item.subtitle = "drummer";
        item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg";
        child = new ChildItem();
        child.title = "AlbumName1";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName2";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName3";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName4";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/13.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName5";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/12.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName6";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/11.jpg";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Artist3";
        item.subtitle = "guitarist";
        item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg";
        child = new ChildItem();
        child.title = "AlbumName1";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/11.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName2";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/12.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName3";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/13.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName4";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName5";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Artist4";
        item.subtitle = "basso";
        item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/4.jpg";
        child = new ChildItem();
        child.title = "AlbumName1";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName2";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/1.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName3";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName4";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/3.jpg";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Artist5";
        item.subtitle = "singer";
        item.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/5.jpg";
        child = new ChildItem();
        child.title = "AlbumName1";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/14.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName2";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/15.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName3";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/6.jpg";
        item.items.add(child);

        child = new ChildItem();
        child.title = "AlbumName4";
        child.imageUrl = "http://pengaja.com/uiapptemplate/newphotos/profileimages/7.jpg";
        item.items.add(child);

        items.add(item);

        return items;
    }

    private static class GroupItem {
        String title;
        String imageUrl;
        String subtitle;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title;
        String imageUrl;
    }

    private static class ChildHolder {
        TextView title;
        TextView publish;
        ImageView image;
        TextView iconPlay;
    }

    private static class GroupHolder {
        TextView title;
        ImageView image;
        TextView subtitle;
        TextView iconLike;
        TextView iconFavorite;
        TextView iconShare;
    }

    private class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter implements View.OnClickListener {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        public ExampleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void setData(List<GroupItem> items) {
            this.items = items;
        }

        @Override
        public ChildItem getChild(int groupPosition, int childPosition) {
            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder holder;
            ChildItem item = getChild(groupPosition, childPosition);
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = inflater.inflate(
                        R.layout.list_item_expandable_media_child, parent,
                        false);
                holder.title = convertView
                        .findViewById(R.id.list_item_expandable_media_child_name);
                holder.publish = convertView
                        .findViewById(R.id.list_item_expandable_media_child_publish);
                holder.iconPlay = convertView
                        .findViewById(R.id.list_item_expandable_media_child_icon_play);
                holder.image = convertView
                        .findViewById(R.id.list_item_expandable_media_child_image);
                holder.iconPlay.setOnClickListener(this);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            ImageUtil.displayImage(holder.image,
                    item.imageUrl, null);
            holder.iconPlay.setTag(childPosition);
            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return items.get(groupPosition).items.size();
        }

        @Override
        public GroupItem getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            GroupHolder holder;
            GroupItem item = getGroup(groupPosition);
            if (convertView == null) {
                holder = new GroupHolder();
                convertView = inflater.inflate(
                        R.layout.list_item_expandable_media, parent, false);
                holder.image = convertView
                        .findViewById(R.id.list_item_expandable_media_image);
                holder.title = convertView
                        .findViewById(R.id.list_item_expandable_media_title);
                holder.subtitle = convertView
                        .findViewById(R.id.list_item_expandable_media_subtitle);
                holder.iconLike = convertView
                        .findViewById(R.id.list_item_expandable_media_like);
                holder.iconFavorite = convertView
                        .findViewById(R.id.list_item_expandable_media_favorite);
                holder.iconShare = convertView
                        .findViewById(R.id.list_item_expandable_media_share);
                holder.iconLike.setOnClickListener(this);
                holder.iconFavorite.setOnClickListener(this);
                holder.iconShare.setOnClickListener(this);
                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            holder.subtitle.setText(item.subtitle.toUpperCase());
            ImageUtil.displayImage(holder.image,
                    item.imageUrl, null);
            holder.iconLike.setTag(groupPosition);
            holder.iconFavorite.setTag(groupPosition);
            holder.iconShare.setTag(groupPosition);


            return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            int possition = (Integer) v.getTag();
            switch (v.getId()) {
                case R.id.list_item_expandable_media_like:
                    // click on explore button
                    Toast.makeText(getActivity(), "Like " + possition, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.list_item_expandable_media_favorite:
                    // click on explore button
                    Toast.makeText(getActivity(), "Favorite " + possition, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.list_item_expandable_media_share:
                    // click on explore button
                    Toast.makeText(getActivity(), "Share " + possition, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.list_item_expandable_media_child_icon_play:
                    // click on explore button
                    Toast.makeText(getActivity(), "Play AlbumName " + possition, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
