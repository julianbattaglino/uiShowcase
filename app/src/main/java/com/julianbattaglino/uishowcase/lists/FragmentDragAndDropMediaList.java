package com.julianbattaglino.uishowcase.lists;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.DragAndDropMediaAdapter;
import com.julianbattaglino.uishowcase.model.DummyContent2;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.TouchViewDraggableManager;

/**
 * Created by Julian Battaglino.
 */

public class FragmentDragAndDropMediaList extends Fragment implements View.OnClickListener {

    private DynamicListView mDynamicListView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_6, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDynamicListView = view.findViewById(R.id.activity_list_view_drag_and_drop_dynamic_listview);
        mDynamicListView.setDividerHeight(0);

        setUpDragAndDrop();
        Toast.makeText(getActivity(), "Long press an item to start dragging",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            TextView tv = (TextView) v;
            Toast.makeText(getActivity(), tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setUpDragAndDrop() {
        final DragAndDropMediaAdapter adapter = new DragAndDropMediaAdapter(
                getActivity(), DummyContent2.getDummyModelDragAndDropTravelList());
        mDynamicListView.setAdapter(adapter);
        mDynamicListView.enableDragAndDrop();
        TouchViewDraggableManager tvdm = new TouchViewDraggableManager(
                R.id.icon);
        mDynamicListView.setDraggableManager(tvdm);
        mDynamicListView
                .setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent,
                                                   View view, int position, long id) {
                        mDynamicListView.startDragging(position);
                        return true;
                    }
                });
    }
}
