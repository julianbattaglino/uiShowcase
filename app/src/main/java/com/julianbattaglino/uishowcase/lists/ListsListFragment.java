package com.julianbattaglino.uishowcase.lists;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.ListsAdapter;

/**
 * Created by Julian Battaglino.
 */

public class ListsListFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    private static final String KEY_LAYOUT_MANAGER = "layoutManager";
    private static final int SPAN_COUNT = 2;
    protected LayoutManagerType mCurrentLayoutManagerType;
    protected RadioButton mLinearLayoutRadioButton;
    protected RadioButton mGridLayoutRadioButton;
    protected RecyclerView mRecyclerView;
    protected ListsAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected String[] mDataset;

    public ListsListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        initDataset();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        rootView.setTag(TAG);

        mRecyclerView = rootView.findViewById(R.id.recyclerView);


        // LinearLayoutManager is used here, this will layout the elements in a similar fashion
        // to the way ListView would layout elements. The RecyclerView.LayoutManager defines how
        // elements are laid out.
        mLayoutManager = new LinearLayoutManager(getActivity());

        mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (LayoutManagerType) savedInstanceState
                    .getSerializable(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);

        mAdapter = new ListsAdapter(mDataset);
        // Set CustomAdapter as the adapter for RecyclerView.
        mRecyclerView.setAdapter(mAdapter);

        mLinearLayoutRadioButton = rootView.findViewById(R.id.linear_layout_rb);
        mLinearLayoutRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerViewLayoutManager(LayoutManagerType.LINEAR_LAYOUT_MANAGER);
            }
        });

        mGridLayoutRadioButton = rootView.findViewById(R.id.grid_layout_rb);
        mGridLayoutRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerViewLayoutManager(LayoutManagerType.GRID_LAYOUT_MANAGER);
            }
        });

        return rootView;
    }

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(LayoutManagerType layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case GRID_LAYOUT_MANAGER:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
                mCurrentLayoutManagerType = LayoutManagerType.GRID_LAYOUT_MANAGER;
                break;
            case LINEAR_LAYOUT_MANAGER:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = LayoutManagerType.LINEAR_LAYOUT_MANAGER;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
    private void initDataset() {
        mDataset = new String[27];
        mDataset[0] = "Expandable Media";
        mDataset[1] = "Expandable Shop";
        mDataset[2] = "Expandable Social";
        mDataset[3] = "Expandable Travel";
        mDataset[4] = "Expandable Universal";
        mDataset[5] = "Drag And drop Media";
        mDataset[6] = "Drag And drop Shop";
        mDataset[7] = "Drag And drop Social";
        mDataset[8] = "Drag And drop Travel";
        mDataset[9] = "Drag And drop";
        mDataset[10] = "Swipe Media";
        mDataset[11] = "Swipe Shop";
        mDataset[12] = "Swipe Social";
        mDataset[13] = "Swipe Travel";
        mDataset[14] = "Swipe Universal";
        mDataset[15] = "Animation Alpha";
        mDataset[16] = "Animation Random";
        mDataset[17] = "Headers Media";
        mDataset[18] = "Headers Shop";
        mDataset[19] = "Headers Social";
        mDataset[20] = "Headers Travel";
        mDataset[21] = "Headers Universal";
        mDataset[22] = "Card Media";
        mDataset[23] = "Card Shop";
        mDataset[24] = "Card Social";
        mDataset[25] = "Card Travel";
        mDataset[26] = "Card Universal";
    }

    private enum LayoutManagerType {
        GRID_LAYOUT_MANAGER,
        LINEAR_LAYOUT_MANAGER
    }
}
