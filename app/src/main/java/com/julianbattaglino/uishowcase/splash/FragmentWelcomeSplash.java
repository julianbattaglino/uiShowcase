package com.julianbattaglino.uishowcase.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.julianbattaglino.uishowcase.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Julian Battaglino.
 */

public class FragmentWelcomeSplash extends Fragment {

    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 3000;
    private LinearLayout l1, l2;
    private Button btnsub;
    private Animation uptodown, downtoup;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_splash_1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnsub = view.findViewById(R.id.buttonsub);
        l1 = view.findViewById(R.id.l1);

        uptodown = AnimationUtils.loadAnimation(getActivity(), R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(getActivity(), R.anim.downtoup);
        l1.setAnimation(uptodown);
        btnsub.setAnimation(downtoup);

        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                SplashListFragment splashListFragment = new SplashListFragment();
                transaction.setCustomAnimations(R.anim.fragment_fade_in, R.anim.fragment_fade_out);
                transaction.replace(R.id.fragment_container, splashListFragment);
                //transaction.addToBackStack(null);

                // Commit the transaction
                try {
                    transaction.commit();
                } catch (IllegalStateException ignored) {
                    // There's no way to avoid getting this if saveInstanceState has already been called.
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }


}
