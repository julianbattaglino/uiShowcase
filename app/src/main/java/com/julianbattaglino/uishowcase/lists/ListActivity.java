package com.julianbattaglino.uishowcase.lists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.julianbattaglino.uishowcase.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Julian Battaglino.
 */

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
        ImageLoader imageLoader = ImageLoader.getInstance();
        if (!imageLoader.isInited()) {
            imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        }

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ListsListFragment listsListFragment = new ListsListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            listsListFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, listsListFragment).commit();
        }
    }
}
