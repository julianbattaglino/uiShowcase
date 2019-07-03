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

public class FragmentExpandableSocialList extends Fragment implements View.OnClickListener {

    // private AnimatedExpandableListView listView;
    private AnimatedExpandableListView listView;
    private ExampleAdapter adapter;

    private ImageView mImage;
    private TextView mName;
    private TextView mPlace;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_3, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mImage = view.findViewById(R.id.expandable_lv_social_image);
        mName = view.findViewById(R.id.expandable_lv_social_name);
        mPlace = view.findViewById(R.id.expandable_lv_social_place);

        ImageUtil.displayRoundImage(mImage,
                "http://pengaja.com/uiapptemplate/newphotos/profileimages/2.jpg", null);

        List<GroupItem> items = new ArrayList<GroupItem>();
        items = fillData(items);

        adapter = new ExampleAdapter(getActivity());
        adapter.setData(items);

        listView = view.findViewById(R.id.expandable_lv_social_list_view);
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
        item.title = "Friends";
        ChildItem child;
        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Enemies";
        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Neutral";
        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Family";
        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Guests";
        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        items.add(item);

        item = new GroupItem();
        item.title = "Students";
        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "John Doe";
        item.items.add(child);

        child = new ChildItem();
        child.title = "Jane Doe";
        item.items.add(child);

        items.add(item);

        return items;
    }

    private static class GroupItem {
        String title;
        int icon = R.string.material_icon_friends;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title;
    }

    private static class ChildHolder {
        TextView title;
        ImageView image;
    }

    private static class GroupHolder {
        TextView title;
        TextView icon;
    }

    private class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
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
                        R.layout.list_item_expandable_social_child, parent,
                        false);
                holder.title = (TextView) convertView
                        .findViewById(R.id.expandable_item_social_child_name);
                holder.image = (ImageView) convertView
                        .findViewById(R.id.expandable_item_social_child_image);
                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            ImageUtil.displayRoundImage(holder.image,
                    "http://pengaja.com/uiapptemplate/newphotos/profileimages/0.jpg", null);

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
                        R.layout.list_item_expandable_social, parent, false);
                holder.title = (TextView) convertView
                        .findViewById(R.id.expandable_item_social_name);
                holder.icon = (TextView) convertView
                        .findViewById(R.id.expandable_item_social_icon);
                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }

            holder.title.setText(item.title);
            holder.icon.setText(item.icon);

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
    }
}
