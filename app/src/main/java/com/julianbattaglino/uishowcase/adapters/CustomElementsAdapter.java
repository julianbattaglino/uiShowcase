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
import com.julianbattaglino.uishowcase.customlist.FragmentFifthCustomElement;
import com.julianbattaglino.uishowcase.customlist.FragmentFirstCustomElement;
import com.julianbattaglino.uishowcase.customlist.FragmentFourthCustomElement;
import com.julianbattaglino.uishowcase.customlist.FragmentSecondCustomElement;
import com.julianbattaglino.uishowcase.customlist.FragmentSixthCustomElement;
import com.julianbattaglino.uishowcase.customlist.FragmentThirdCustomElement;

/**
 * Created by Julian Battaglino.
 */

/**
 * Provide views to RecyclerView with data from mDataSet.
 */
public class CustomElementsAdapter extends RecyclerView.Adapter<CustomElementsAdapter.ViewHolder> {
    private static final String TAG = "CustomAdapter";

    private String[] mDataSet;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public CustomElementsAdapter(String[] dataSet) {
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
                            newFragment = new FragmentFirstCustomElement();
                            break;

                        case 1:
                            newFragment = new FragmentSecondCustomElement();
                            break;

                        case 2:
                            newFragment = new FragmentThirdCustomElement();
                            break;

                        case 3:
                            newFragment = new FragmentFourthCustomElement();
                            break;

                        case 4:
                            newFragment = new FragmentFifthCustomElement();
                            break;

                        case 5:
                            newFragment = new FragmentSixthCustomElement();
                            break;

                        default:
                            newFragment = new FragmentFirstCustomElement();
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
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }

    }
}