package com.julianbattaglino.uishowcase.login;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.login.creativelogin.FragmentCreativeLoginSignIn;

public class LoginActivity extends AppCompatActivity implements FragmentCreativeLoginSignIn.OnFragmentInteractionListener {

    private String backStateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
            LoginListFragment loginListFragment = new LoginListFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            loginListFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, loginListFragment).commit();

        }

    }

    public void replaceFragment(Fragment fragment) {

        backStateName = fragment.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment_container, fragment, backStateName);
            ft.addToBackStack(backStateName);
            ft.commit();
        }

    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("fragmentInte", uri.toString());
    }
}


