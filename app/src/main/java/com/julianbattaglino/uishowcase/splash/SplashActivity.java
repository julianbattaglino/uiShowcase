package com.julianbattaglino.uishowcase.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.julianbattaglino.uishowcase.R;

/**
 * Created by Julian Battaglino.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
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
            SplashListFragment splashListFragment = new SplashListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            splashListFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, splashListFragment).commit();
        }
    }
}
