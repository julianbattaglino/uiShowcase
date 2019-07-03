package com.julianbattaglino.uishowcase.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.customviews.ArcImageView;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;
import com.tumblr.backboard.performer.Performer;

/**
 * Created by Julian Battaglino.
 */
public class FragmentTravelProfile extends Fragment {

    private ArcImageView profile;
    private TextView lbl1, lbl2, lbl3, lbl_count1, lbl_count2, lbl_count3, name;
    //private RelativeLayout back1, back2, back3, back4;
    //private LinearLayout pics;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile_1, null);
        // //TypefaceHelper.typeface(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //((MainActivity) getActivity()).getMyActionBar().hide();

        lbl1 = (TextView) getView().findViewById(R.id.lbl1);
        lbl2 = (TextView) getView().findViewById(R.id.lbl2);
        lbl3 = (TextView) getView().findViewById(R.id.lbl3);
        lbl_count1 = (TextView) getView().findViewById(R.id.lbl_follow);
        lbl_count2 = (TextView) getView().findViewById(R.id.lbl_following);
        lbl_count3 = (TextView) getView().findViewById(R.id.lbl_photos);

        name = (TextView) getView().findViewById(R.id.name);

        //back1 = (RelativeLayout) getView().findViewById(R.id.back1);
        //back2 = (RelativeLayout) getView().findViewById(R.id.back2);
        //back3 = (RelativeLayout) getView().findViewById(R.id.back3);
        //back4 = (RelativeLayout) getView().findViewById(R.id.back4);
        //pics = (LinearLayout) getView().findViewById(R.id.pic_wrapper);

        profile = (ArcImageView) getView().findViewById(R.id.profile_img);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimation();
            }
        }, 300);

    }

    private void startAnimation() {

        AnimationUtils.landMeY(lbl1, 800);
        AnimationUtils.landMeY(lbl2, 800);
        AnimationUtils.landMeY(lbl3, 800);

        AnimationUtils.enterTop(profile, 400).addListener(new SimpleSpringListener() {
            @Override
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
                profile.setBorderColor(Color.parseColor("#FFFFFF"));
                profile.setEnableRotation(true);
                profile.toogleValue();
            }
        });


        AnimationUtils.showMe(lbl_count1, 800).addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                lbl_count1.setText((int) (460 * (spring.getCurrentValue())) + "");
            }
        });
        AnimationUtils.showMe(lbl_count2, 800).addListener(new Performer(lbl_count2, View.ALPHA)).addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                lbl_count2.setText((int) (592 * (spring.getCurrentValue())) + "");
            }
        }).setRestSpeedThreshold(0.4);

        AnimationUtils.showMe(lbl_count3, 800).addListener(new Performer(lbl_count3, View.ALPHA)).addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                lbl_count3.setText((int) (279 * (spring.getCurrentValue())) + "");
            }
        }).setRestSpeedThreshold(0.9);

        //AnimationUtils.showMe(pics, 800);
        AnimationUtils.landMeY(name, 400);
    }


}
