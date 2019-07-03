package com.julianbattaglino.uishowcase.profile;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.ProfileAdapter2;
import com.julianbattaglino.uishowcase.customviews.ArcImageView;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

/**
 * Created by Julian Battaglino.
 */
public class FragmentSocialProfile extends Fragment {
    View v;
    ArcImageView image;
    LinearLayout bg_profile;
    TextView post_text, following_text, follower_text, name, address;
    RecyclerView rv;
    ArrayList<String> listData = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_Dark);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_profile_2, null);

        //    //TypefaceHelper.typeface(v, App.getOpenSansTypeFace());
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listData.add("Hummingbird");
        listData.add("Finch");
        listData.add("Cockatoo");
        listData.add("Crane");
        listData.add("Toucan");
        listData.add("Kingfisher");
        listData.add("Swallow");
        listData.add("Heron");

        image = (ArcImageView) getView().findViewById(R.id.image);
        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.main);
        toolbar.setTitle("PROFILE");

        //((MainActivity) getActivity()).getMyActionBar().hide();

        post_text = getView().findViewById(R.id.post_text);
        following_text = getView().findViewById(R.id.following_text);
        follower_text = getView().findViewById(R.id.follower_text);
        name = getView().findViewById(R.id.name);
        address = getView().findViewById(R.id.address);

        rv = getView().findViewById(R.id.rv);

        AnimationUtils.popOut(post_text, 200);
        AnimationUtils.popOut(following_text, 300);
        AnimationUtils.popOut(follower_text, 400);

        AnimationUtils.popOut(image, 1200);

        AnimationUtils.enterBottom(name, 500);
        AnimationUtils.enterBottom(address, 600);


        bg_profile = (LinearLayout) getView().findViewById(R.id.bg_profile);

        image.setBorderColor(Color.WHITE);
        image.setBorderWidth(3);

        SpringConfig.defaultConfig = SpringConfig.fromBouncinessAndSpeed(12, 35);

        final Spring sw = SpringSystem.create().createSpring();

        AnimationUtils.makeRoundCorner(bg_profile, Color.parseColor("#FF5880C1"), 50, 1000);

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        ProfileAdapter2 adapter = new ProfileAdapter2(getActivity(), listData);

        rv.setAdapter(new ScaleInAnimationAdapter(adapter));

        adapter.setItemClickListener(new ProfileAdapter2.onItemClickListener() {
            @Override
            public void onItemClicked(int position, View v) {
                // TODO add logic
                Toast.makeText(getContext(), String.format("Item %s Clicked!", position), Toast.LENGTH_SHORT).show();
            }
        });

        final RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) bg_profile.getLayoutParams();
        sw.setCurrentValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, getResources().getDisplayMetrics()));

        sw.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                params.width = (int) spring.getCurrentValue();
                bg_profile.setLayoutParams(params);
            }

            @Override
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
                image.setProgress(100);
                AnimationUtils.setCount(post_text, 25, "k\nAll post");
                AnimationUtils.setCount(follower_text, 850, "k\nfollowers");
                AnimationUtils.setCount(following_text, 85, "k\nfollowing");
            }
        });

        bg_profile.postDelayed(new Runnable() {
            @Override
            public void run() {

                sw.setEndValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 110, getResources().getDisplayMetrics()));

            }
        }, 500);

    }


}
