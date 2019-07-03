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
import com.julianbattaglino.uishowcase.adapters.SwipeToDissmissShopAdapter;
import com.julianbattaglino.uishowcase.model.DummyContent2;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SimpleSwipeUndoAdapter;

/**
 * Created by Julian Battaglino.
 */

public class FragmentSwipeShopList extends Fragment implements View.OnClickListener {

    private DynamicListView mDynamicListView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_10, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView price = view.findViewById(R.id.activity_swip_to_dissmiss_shop_price);
        TextView orderNumber = view.findViewById(R.id.activity_swip_to_dissmiss_shop_order_number);
        TextView proceed = view.findViewById(R.id.activity_swip_to_dissmiss_shop_proceed);

        proceed.setOnClickListener(this);

        mDynamicListView = view.findViewById(R.id.activity_swip_to_dissmiss_shop_dynamic_listview);

        setUpSwipeToDissmiss();
    }

    private void setUpSwipeToDissmiss() {
        final SwipeToDissmissShopAdapter adapter = new SwipeToDissmissShopAdapter(
                getActivity(), DummyContent2.getDummyModelDragAndDropShopList());
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
            case R.id.activity_swip_to_dissmiss_shop_proceed:
                // click on explore button
                Toast.makeText(getActivity(), "Proceed...", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
