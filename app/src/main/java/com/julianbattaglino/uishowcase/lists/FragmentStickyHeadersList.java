package com.julianbattaglino.uishowcase.lists;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.MyStickyListHeadersAdapter;
import com.julianbattaglino.uishowcase.adapters.MyStickyListHeadersMediaAdapter;
import com.julianbattaglino.uishowcase.adapters.MyStickyListHeadersShopAdapter;
import com.julianbattaglino.uishowcase.adapters.MyStickyListHeadersSocialAdapter;
import com.julianbattaglino.uishowcase.adapters.MyStickyListHeadersTravelAdapter;
import com.julianbattaglino.uishowcase.model.DummyContent2;
import com.julianbattaglino.uishowcase.utils.Constants;
import com.nhaarman.listviewanimations.appearance.StickyListHeadersAdapterDecorator;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.util.StickyListHeadersListViewWrapper;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by Julian Battaglino.
 */

public class FragmentStickyHeadersList extends Fragment {

    private DynamicListView mDynamicListView;
    private String category;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_11, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mDynamicListView = view.findViewById(R.id.dynamic_listview);
        category = getArguments().getString(Constants.ARG_PARAM1);

        StickyListHeadersListView listView = view.findViewById(R.id.activity_stickylistheaders_listview);
        listView.setFitsSystemWindows(true);

        AlphaInAnimationAdapter animationAdapter;
        if (category.equals(Constants.STICKY_LIST_HEADERS_TRAVEL)) {
            MyStickyListHeadersTravelAdapter adapterTravel = new MyStickyListHeadersTravelAdapter(
                    getActivity());
            animationAdapter = new AlphaInAnimationAdapter(adapterTravel);
        } else if (category.equals(Constants.STICKY_LIST_HEADERS_SOCIAL)) {
            MyStickyListHeadersSocialAdapter adapterSocial = new MyStickyListHeadersSocialAdapter(
                    getActivity(), DummyContent2.getDummyModelList());
            animationAdapter = new AlphaInAnimationAdapter(adapterSocial);
        } else if (category.equals(Constants.STICKY_LIST_HEADERS_MEDIA)) {
            listView.setBackgroundResource(R.drawable.background_media);
            MyStickyListHeadersMediaAdapter adapterSocial = new MyStickyListHeadersMediaAdapter(
                    getActivity(), DummyContent2.getDummyModelList());
            animationAdapter = new AlphaInAnimationAdapter(adapterSocial);
        } else if (category.equals(Constants.STICKY_LIST_HEADERS_SHOP)) {
            listView.setBackgroundResource(R.drawable.background_shop);
            MyStickyListHeadersShopAdapter adapterSocial = new MyStickyListHeadersShopAdapter(
                    getActivity(), DummyContent2.getDummyModelDragAndDropShopList());
            animationAdapter = new AlphaInAnimationAdapter(adapterSocial);
        } else {
            MyStickyListHeadersAdapter adapter = new MyStickyListHeadersAdapter(
                    getActivity());
            animationAdapter = new AlphaInAnimationAdapter(adapter);
        }

        StickyListHeadersAdapterDecorator stickyListHeadersAdapterDecorator = new StickyListHeadersAdapterDecorator(
                animationAdapter);
        stickyListHeadersAdapterDecorator
                .setListViewWrapper(new StickyListHeadersListViewWrapper(
                        listView));
        assert animationAdapter.getViewAnimator() != null;
        animationAdapter.getViewAnimator().setInitialDelayMillis(500);
        assert stickyListHeadersAdapterDecorator.getViewAnimator() != null;
        stickyListHeadersAdapterDecorator.getViewAnimator()
                .setInitialDelayMillis(500);
        listView.setAdapter(stickyListHeadersAdapterDecorator);
    }
}
