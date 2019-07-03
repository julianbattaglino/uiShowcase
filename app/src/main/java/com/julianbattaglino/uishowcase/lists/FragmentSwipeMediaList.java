package com.julianbattaglino.uishowcase.lists;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.SwipeToDissmissMediaAdapter;
import com.julianbattaglino.uishowcase.model.DummyContent2;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

/**
 * Created by Julian Battaglino.
 */

public class FragmentSwipeMediaList extends Fragment implements View.OnClickListener {

    private DynamicListView mDynamicListView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_9, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView play = view.findViewById(R.id.activity_swip_to_dissmiss_media_play);
        TextView like = view.findViewById(R.id.activity_swip_to_dissmiss_media_like);
        TextView favorite = view.findViewById(R.id.activity_swip_to_dissmiss_media_favorite);
        TextView share = view.findViewById(R.id.activity_swip_to_dissmiss_media_share);
        TextView time = view.findViewById(R.id.activity_swip_to_dissmiss_media_time);
        TextView playlistName = view.findViewById(R.id.activity_swip_to_dissmiss_media_playlist);
        TextView songs = view.findViewById(R.id.activity_swip_to_dissmiss_media_songs);

        play.setOnClickListener(this);
        like.setOnClickListener(this);
        favorite.setOnClickListener(this);
        share.setOnClickListener(this);

        mDynamicListView = view.findViewById(R.id.activity_swip_to_dissmiss_media_dynamic_listview);
        setUpSwipeToDissmiss();
    }

    private void setUpSwipeToDissmiss() {
        final SwipeToDissmissMediaAdapter adapter = new SwipeToDissmissMediaAdapter(
                getActivity(), DummyContent2.getDummyModelList());
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

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.activity_swip_to_dissmiss_media_play:
                // click on explore button
                Toast.makeText(getActivity(), "Play playlist", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_swip_to_dissmiss_media_like:
                // click on explore button
                Toast.makeText(getActivity(), "Like", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_swip_to_dissmiss_media_favorite:
                // click on explore button
                Toast.makeText(getActivity(), "Favorite", Toast.LENGTH_SHORT).show();
                break;
            case R.id.activity_swip_to_dissmiss_media_share:
                // click on explore button
                Toast.makeText(getActivity(), "Share", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
