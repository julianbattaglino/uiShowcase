package com.julianbattaglino.uishowcase.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.lists.FragmentCardMediaList;
import com.julianbattaglino.uishowcase.lists.FragmentCardShopList;
import com.julianbattaglino.uishowcase.lists.FragmentCardSocialList;
import com.julianbattaglino.uishowcase.lists.FragmentCardTravelList;
import com.julianbattaglino.uishowcase.lists.FragmentCardUniversalList;
import com.julianbattaglino.uishowcase.lists.FragmentDragAndDropMediaList;
import com.julianbattaglino.uishowcase.lists.FragmentDragAndDropShopList;
import com.julianbattaglino.uishowcase.lists.FragmentDragAndDropSocialList;
import com.julianbattaglino.uishowcase.lists.FragmentDragAndDropTravelList;
import com.julianbattaglino.uishowcase.lists.FragmentExpandableMediaList;
import com.julianbattaglino.uishowcase.lists.FragmentExpandableShopList;
import com.julianbattaglino.uishowcase.lists.FragmentExpandableSocialList;
import com.julianbattaglino.uishowcase.lists.FragmentExpandableTravelList;
import com.julianbattaglino.uishowcase.lists.FragmentExpandableUniversalList;
import com.julianbattaglino.uishowcase.lists.FragmentStickyHeadersList;
import com.julianbattaglino.uishowcase.lists.FragmentSwipeMediaList;
import com.julianbattaglino.uishowcase.lists.FragmentSwipeShopList;
import com.julianbattaglino.uishowcase.lists.FragmentSwipeSocialAndTravelList;
import com.julianbattaglino.uishowcase.lists.FragmentUniversalList;
import com.julianbattaglino.uishowcase.utils.Constants;

/**
 * Created by Julian Battaglino.
 */

public class ListsAdapter extends RecyclerView.Adapter<ListsAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public ListsAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextView().setText(mDataSet[position]);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Create fragment and give it an argument specifying the article it should show
                    Fragment newFragment;
                    Bundle args;
                    switch (getAdapterPosition()) {
                        case 0:
                            newFragment = new FragmentExpandableMediaList();
                            break;

                        case 1:
                            newFragment = new FragmentExpandableShopList();
                            break;

                        case 2:
                            newFragment = new FragmentExpandableSocialList();
                            break;

                        case 3:
                            newFragment = new FragmentExpandableTravelList();
                            break;

                        case 4:
                            newFragment = new FragmentExpandableUniversalList();
                            break;

                        case 5:
                            newFragment = new FragmentDragAndDropMediaList();
                            break;

                        case 6:
                            newFragment = new FragmentDragAndDropShopList();
                            break;

                        case 7:
                            newFragment = new FragmentDragAndDropSocialList();
                            break;

                        case 8:
                            newFragment = new FragmentDragAndDropTravelList();
                            break;

                        case 9:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.LIST_VIEW_OPTION_DRAG_AND_DROP);

                            newFragment = new FragmentUniversalList();
                            newFragment.setArguments(args);
                            break;

                        case 10:
                            newFragment = new FragmentSwipeMediaList();
                            break;

                        case 11:
                            newFragment = new FragmentSwipeShopList();
                            break;

                        case 12:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.SWIPE_TO_DISSMISS_SOCIAL);

                            newFragment = new FragmentSwipeSocialAndTravelList();
                            newFragment.setArguments(args);
                            break;

                        case 13:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.SWIPE_TO_DISSMISS_TRAVEL);

                            newFragment = new FragmentSwipeSocialAndTravelList();
                            newFragment.setArguments(args);
                            break;

                        case 14:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.LIST_VIEW_OPTION_SWIPE_TO_DISSMISS);

                            newFragment = new FragmentSwipeSocialAndTravelList();
                            newFragment.setArguments(args);
                            break;

                        case 15:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.LIST_VIEW_OPTION_APPERANCE_ALPHA);

                            newFragment = new FragmentUniversalList();
                            newFragment.setArguments(args);
                            break;

                        case 16:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.LIST_VIEW_OPTION_APPERANCE_RANDOM);

                            newFragment = new FragmentUniversalList();
                            newFragment.setArguments(args);
                            break;

                        case 17:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.STICKY_LIST_HEADERS_MEDIA);

                            newFragment = new FragmentStickyHeadersList();
                            newFragment.setArguments(args);
                            break;

                        case 18:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.STICKY_LIST_HEADERS_SHOP);

                            newFragment = new FragmentStickyHeadersList();
                            newFragment.setArguments(args);
                            break;

                        case 19:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.STICKY_LIST_HEADERS_SOCIAL);

                            newFragment = new FragmentStickyHeadersList();
                            newFragment.setArguments(args);
                            break;

                        case 20:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.STICKY_LIST_HEADERS_TRAVEL);

                            newFragment = new FragmentStickyHeadersList();
                            newFragment.setArguments(args);
                            break;

                        case 21:
                            args = new Bundle();
                            args.putString(Constants.ARG_PARAM1, Constants.STICKY_LIST_HEADERS_UNIVERSAL);

                            newFragment = new FragmentStickyHeadersList();
                            newFragment.setArguments(args);
                            break;

                        case 22:
                            newFragment = new FragmentCardMediaList();
                            break;

                        case 23:
                            newFragment = new FragmentCardShopList();
                            break;

                        case 24:
                            newFragment = new FragmentCardSocialList();
                            break;

                        case 25:
                            newFragment = new FragmentCardTravelList();
                            break;

                        case 26:
                            newFragment = new FragmentCardUniversalList();
                            break;

                        default:
                            newFragment = new FragmentExpandableMediaList();
                            break;

                    }
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.fragment_container, newFragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();


                }
            });
            textView = v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }

    }
}
