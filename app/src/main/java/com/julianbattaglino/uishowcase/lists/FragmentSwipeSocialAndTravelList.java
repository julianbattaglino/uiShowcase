package com.julianbattaglino.uishowcase.lists;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.DefaultAdapter;
import com.julianbattaglino.uishowcase.adapters.SwipeToDissmissTravelAndSocialAdapter;
import com.julianbattaglino.uishowcase.model.DummyContent2;
import com.julianbattaglino.uishowcase.utils.Constants;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

/**
 * Created by Julian Battaglino.
 */

public class FragmentSwipeSocialAndTravelList extends Fragment {

    private DynamicListView mDynamicListView;
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

        String category = getArguments().getString(Constants.ARG_PARAM1);

        if (category.equals(Constants.SWIPE_TO_DISSMISS_TRAVEL)) {
            setUpSwipeToDissmissTravel();
        } else if (category.equals(Constants.SWIPE_TO_DISSMISS_SOCIAL)) {
            mDynamicListView
                    .setBackgroundResource(R.drawable.drag_and_drop_background_image);
            setUpSwipeToDissmissSocial();
        } else {
            setUpSwipeToDissmiss();
        }
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

    private void setUpSwipeToDissmissTravel() {
        final SwipeToDissmissTravelAndSocialAdapter adapter = new SwipeToDissmissTravelAndSocialAdapter(
                getActivity(), DummyContent2.getDummyModelSwipeToDissmissTravelList(),
                Constants.SWIPE_TO_DISSMISS_TRAVEL);
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

    private void setUpSwipeToDissmissSocial() {
        final SwipeToDissmissTravelAndSocialAdapter adapter = new SwipeToDissmissTravelAndSocialAdapter(
                getActivity(), DummyContent2.getDummyModelSwipeToDissmissSocialList(),
                Constants.SWIPE_TO_DISSMISS_SOCIAL);
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
}
