package com.julianbattaglino.uishowcase.splash;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.julianbattaglino.uishowcase.R;

/**
 * Created by Julian Battaglino.
 */

public class FragmentDownFadeInKBSplash extends Fragment {

    private View view;

    private KenBurnsView mKenBurns;
    private ImageView mLogo;
    private TextView welcomeText;

    private Handler handler;
    private Runnable runnable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_splash_3, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mKenBurns = view.findViewById(R.id.ken_burns_images);
        mLogo = view.findViewById(R.id.logo);
        welcomeText = view.findViewById(R.id.welcome_text);

        mKenBurns.setImageResource(R.drawable.backgroundhindu);
        animation2();
        animation3();

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
        handler.postDelayed(runnable, 5000);
    }

    private void animation2() {
        mLogo.setAlpha(1.0F);
        Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.translate_top_to_center);
        mLogo.startAnimation(anim);
    }

    private void animation3() {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(welcomeText, "alpha", 0.0F, 1.0F);
        alphaAnimation.setStartDelay(1700);
        alphaAnimation.setDuration(500);
        alphaAnimation.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}
