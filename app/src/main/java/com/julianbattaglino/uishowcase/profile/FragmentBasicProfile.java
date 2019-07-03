package com.julianbattaglino.uishowcase.profile;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.rebound.Spring;
import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

/**
 * Created by Julian Battaglino.
 */
public class FragmentBasicProfile extends Fragment {
    private LinearLayout block1, block2, block3;
    private TextView profile_name;
    private Button follow;
    private Button info;
    private boolean flag = false;
    private View v;
    private Spring s, s1;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_profile_3, null);

//        ////TypefaceHelper.typeface(v, App.getHelveticaNeueArabic());
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //((MainActivity) getActivity()).getMyActionBar().hide();

      /*  image = (ImageView) getView().findViewById(R.id.image);
        image.postDelayed(new Runnable() {
            @Override
            public void run() {
                Picasso.with(getActivity()).load(R.drawable.trans).into(image);
               // image.setBackgroundResource(R.drawable.profile_image_2);
            }
        }, 200);
*/
        profile_name = (TextView) getView().findViewById(R.id.profile_name);
        follow = (Button) getView().findViewById(R.id.btn_follow);
        info = (Button) getView().findViewById(R.id.btn_Info);
        block1 = (LinearLayout) getView().findViewById(R.id.block_1);
        block2 = (LinearLayout) getView().findViewById(R.id.block_2);
        block3 = (LinearLayout) getView().findViewById(R.id.block_3);

        final Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);


        //AnimationUtils.enterTop(toolbar, 500);
        AnimationUtils.enterLeft(profile_name, 800);
        AnimationUtils.enterLeft(block1, 600);
        AnimationUtils.enterRight(block3, 600);
        AnimationUtils.popOut(block2, 600);

        final int width = getResources().getDisplayMetrics().widthPixels;
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    AnimationUtils.changeBound(getActivity(), follow, width, 100);
                    AnimationUtils.makeRoundCorner(follow, Color.parseColor("#9674B49B"), 30, 300);
                    follow.setText("Following");
                    flag = false;
                } else {
                    AnimationUtils.makeRoundCorner(follow, Color.parseColor("#FF74B49B"), 30, 300);
                    AnimationUtils.changeBound(getActivity(), follow, 200, 100);
                    follow.setText("Followed");
                    flag = true;
                }

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag) {
                    AnimationUtils.changeBound(getActivity(), info, width, 100);
                    AnimationUtils.makeRoundCorner(info, Color.parseColor("#96A7D7C5"), 30, 300);
                    info.setText("Profile");
                    flag = false;
                } else {
                    AnimationUtils.makeRoundCorner(info, Color.parseColor("#FFA7D7C5"), 30, 300);
                    AnimationUtils.changeBound(getActivity(), info, 200, 100);
                    info.setText("On It!");
                    flag = true;
                }


            }
        });

    }
}
