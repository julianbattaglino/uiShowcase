package com.julianbattaglino.uishowcase.splash;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julianbattaglino.uishowcase.R;

/**
 * Created by Julian Battaglino.
 */

public class FragmentGoodSplash extends Fragment {

    private Handler handler;
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash_4, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*We "simulate" a real process, because the idea fo this example is to make the transition
        when the view real solve all process and not using a timer.
        https://medium.freecodecamp.org/how-to-make-a-splash-screen-on-android-correctly-64ab74482a33
         */
        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                SplashListFragment splashListFragment = new SplashListFragment();
                transaction.setCustomAnimations(R.anim.fragment_fade_in, R.anim.fragment_fade_out);
                transaction.replace(R.id.fragment_container, splashListFragment);
                //transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}

