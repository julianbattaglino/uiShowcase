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
import com.julianbattaglino.uishowcase.animations.FragmentAnimation1;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation10;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation11;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation12;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation13;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation14;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation2;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation3;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation4;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation5;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation6;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation7;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation8;
import com.julianbattaglino.uishowcase.animations.FragmentAnimation9;

public class AnimationAdapter extends RecyclerView.Adapter<AnimationAdapter.ViewHolder> {
    private static final String TAG = "AnimationAdapter";

    private String[] mDataSet;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public AnimationAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AnimationAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);

        return new AnimationAdapter.ViewHolder(v);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AnimationAdapter.ViewHolder viewHolder, final int position) {
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
                            newFragment = new FragmentAnimation1();
                            break;

                        case 1:
                            newFragment = new FragmentAnimation2();
                            break;

                        case 2:
                            newFragment = new FragmentAnimation3();
                            break;

                        case 3:
                            newFragment = new FragmentAnimation4();
                            break;

                        case 4:
                            newFragment = new FragmentAnimation5();
                            break;

                        case 5:
                            newFragment = new FragmentAnimation6();
                            break;

                        case 6:
                            newFragment = new FragmentAnimation7();
                            break;

                        case 7:
                            newFragment = new FragmentAnimation8();
                            break;

                        case 8:
                            newFragment = new FragmentAnimation9();
                            break;

                        case 9:
                            newFragment = new FragmentAnimation10();
                            break;

                        case 10:
                            newFragment = new FragmentAnimation11();
                            break;

                        case 11:
                            newFragment = new FragmentAnimation12();
                            break;

                        case 12:
                            newFragment = new FragmentAnimation13();
                            break;

                        case 13:
                            newFragment = new FragmentAnimation14();
                            break;


                        default:
                            newFragment = new FragmentAnimation1();
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


