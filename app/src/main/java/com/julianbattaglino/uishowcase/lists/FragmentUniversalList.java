package com.julianbattaglino.uishowcase.lists;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.DefaultAdapter;
import com.julianbattaglino.uishowcase.model.DummyContent2;
import com.julianbattaglino.uishowcase.utils.Constants;
import com.nhaarman.listviewanimations.appearance.AnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.ScaleInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingLeftInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingRightInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.TouchViewDraggableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

import java.util.Random;

/**
 * Created by Julian Battaglino.
 */

public class FragmentUniversalList extends Fragment {

    private DynamicListView mDynamicListView;
    private String category;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_8, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDynamicListView = view.findViewById(R.id.dynamic_listview);
        category = getArguments().getString(Constants.ARG_PARAM1);

        setUpListView(category);
    }

    private void setUpListView(String category) {
        if (category
                .equals(Constants.LIST_VIEW_OPTION_DRAG_AND_DROP)) {
            setUpDragAndDrop();
            Toast.makeText(getActivity(), "Long press an item to start dragging",
                    Toast.LENGTH_SHORT).show();
        } else if (category
                .equals(Constants.LIST_VIEW_OPTION_SWIPE_TO_DISSMISS)) {
            setUpSwipeToDissmiss();
        } else if (category
                .equals(Constants.LIST_VIEW_OPTION_APPERANCE_ALPHA)) {
            appearanceAnimate(0);
        } else if (category
                .equals(Constants.LIST_VIEW_OPTION_APPERANCE_RANDOM)) {
            appearanceAnimate(new Random().nextInt(5));
        }
    }

    private void setUpDragAndDrop() {
        final DefaultAdapter adapter = new DefaultAdapter(getActivity(),
                DummyContent2.getDummyModelList(), true);
        mDynamicListView.setAdapter(adapter);
        mDynamicListView.enableDragAndDrop();
        mDynamicListView.setDraggableManager(new TouchViewDraggableManager(
                R.id.icon));
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

    private void setUpSwipeToDissmiss() {
        final DefaultAdapter adapter = new DefaultAdapter(getActivity(),
                DummyContent2.getDummyModelList(), false);
        SimpleSwipeUndoAdapter swipeUndoAdapter = new SimpleSwipeUndoAdapter(
                adapter, getActivity(), new OnDismissCallback() {
            @Override
            public void onDismiss(@NonNull final ViewGroup listView,
                                  @NonNull final int[] reverseSortedPositions) {
                for (int position : reverseSortedPositions) {
                    adapter.remove(position);
                }
            }
        });
        swipeUndoAdapter.setAbsListView(mDynamicListView);
        mDynamicListView.setAdapter(swipeUndoAdapter);
        mDynamicListView.enableSimpleSwipeUndo();
    }

    private void appearanceAnimate(int key) {
        BaseAdapter adapter = new DefaultAdapter(getActivity(),
                DummyContent2.getDummyModelList(), false);
        AnimationAdapter animAdapter;
        switch (key) {
            default:
            case 0:
                animAdapter = new AlphaInAnimationAdapter(adapter);
                break;
            case 1:
                animAdapter = new ScaleInAnimationAdapter(adapter);
                break;
            case 2:
                animAdapter = new SwingBottomInAnimationAdapter(adapter);
                break;
            case 3:
                animAdapter = new SwingLeftInAnimationAdapter(adapter);
                break;
            case 4:
                animAdapter = new SwingRightInAnimationAdapter(adapter);
                break;
        }
        animAdapter.setAbsListView(mDynamicListView);
        mDynamicListView.setAdapter(animAdapter);
    }
}
