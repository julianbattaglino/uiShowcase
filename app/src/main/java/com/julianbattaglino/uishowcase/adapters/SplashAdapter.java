package com.julianbattaglino.uishowcase.adapters;

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
import com.julianbattaglino.uishowcase.splash.FragmentDownFadeInKBSplash;
import com.julianbattaglino.uishowcase.splash.FragmentDownKBSplash;
import com.julianbattaglino.uishowcase.splash.FragmentFadeInKBSplash;
import com.julianbattaglino.uishowcase.splash.FragmentGoodSplash;
import com.julianbattaglino.uishowcase.splash.FragmentJumboSplash;
import com.julianbattaglino.uishowcase.splash.FragmentWelcomeSplash;

/**
 * Created by Julian Battaglino.
 */

public class SplashAdapter extends RecyclerView.Adapter<SplashAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public SplashAdapter(String[] dataSet) {
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
                    switch (getAdapterPosition()) {
                        case 0:
                            newFragment = new FragmentWelcomeSplash();
                            break;

                        case 1:
                            newFragment = new FragmentJumboSplash();
                            break;

                        case 2:
                            newFragment = new FragmentFadeInKBSplash();
                            break;

                        case 3:
                            newFragment = new FragmentDownKBSplash();
                            break;

                        case 4:
                            newFragment = new FragmentDownFadeInKBSplash();
                            break;

                        case 5:
                            newFragment = new FragmentGoodSplash();
                            break;

                        default:
                            newFragment = new FragmentWelcomeSplash();
                            break;

                    }
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.fragment_container, newFragment);
                    //transaction.addToBackStack(null);

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
