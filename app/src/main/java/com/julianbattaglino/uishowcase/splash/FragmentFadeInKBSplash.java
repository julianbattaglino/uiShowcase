package com.julianbattaglino.uishowcase.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.julianbattaglino.uishowcase.R;

/**
 * Created by Julian Battaglino.
 */

public class FragmentFadeInKBSplash extends Fragment {

    private View view;

    private KenBurnsView mKenBurns;
    private ImageView mLogo;

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

        mKenBurns.setImageResource(R.drawable.asiasplash);
        animation();

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

    private void animation() {
        ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(mLogo, "scaleX", 5.0F, 1.0F);
        scaleXAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleXAnimation.setDuration(1200);
        ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(mLogo, "scaleY", 5.0F, 1.0F);
        scaleYAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        scaleYAnimation.setDuration(1200);
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(mLogo, "alpha", 0.0F, 1.0F);
        alphaAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaAnimation.setDuration(1200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleXAnimation).with(scaleYAnimation).with(alphaAnimation);
        animatorSet.setStartDelay(500);
        animatorSet.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}
