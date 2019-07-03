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
import android.widget.ImageView;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.model.ProfileMessages;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;
import com.julianbattaglino.uishowcase.utils.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian Battaglino.
 */
public class FragmentModernProfile extends Fragment {
    private TextView profile_name, tag1, tag2, title, profile_name_1;
    private ImageView img1, img2, img3;
    private View v;
    private QuickAdapter<ProfileMessages> adapter;
    //private RecyclerView rv;
    private List<ProfileMessages> listData = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_profile_4, null);

        //TypefaceHelper.typeface(v, App.getBlackJar());
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);

        title = (TextView) getView().findViewById(R.id.title);
        profile_name = (TextView) getView().findViewById(R.id.profile_name);
        profile_name_1 = (TextView) getView().findViewById(R.id.profile_name_1);
        tag1 = (TextView) getView().findViewById(R.id.tag1);
        tag2 = (TextView) getView().findViewById(R.id.tag2);

        //rv = (RecyclerView) getView().findViewById(R.id.rv);

        //TypefaceHelper.typeface(tag1, App.getNew_Cicle());
        //TypefaceHelper.typeface(tag2, App.getNew_Cicle());


        img1 = (ImageView) getView().findViewById(R.id.img1);
        img2 = (ImageView) getView().findViewById(R.id.img2);
        img3 = (ImageView) getView().findViewById(R.id.img3);

        AnimationUtils.rotateClockWise(img1, 1000);
        AnimationUtils.rotateClockWise(img2, 1100);
        AnimationUtils.rotateClockWise(img3, 1200);

        AnimationUtils.rotateXwithColor(profile_name_1, Color.parseColor("#F56F6C"), 1200);

        AnimationUtils.showMe(tag1, 900);
        AnimationUtils.showMe(tag2, 1000);

        AnimationUtils.showMe(profile_name, 600);
        AnimationUtils.showMe(profile_name, 800);

        AnimationUtils.showMe(profile_name_1, 600);
        AnimationUtils.showMe(profile_name_1, 800);

        AnimationUtils.enterTop(toolbar, 500);

        /*adapter = new QuickAdapter<ProfileMessages>(getActivity(), R.layout.row_layout_profile_4) {
            @Override
            protected void convert(final BaseAdapterHelper helper, ProfileMessages item) {

                helper.getImageView(R.id.row_image).setImageResource(item.getImage());
                helper.getTextView(R.id.time_name).setText(item.getTime_ago() + " by:" + item.getFrom());
                helper.getTextView(R.id.app_name).setText(item.getApp_name());
                //TypefaceHelper.typeface(helper.getTextView(R.id.time_name), App.getCalibri());
                //TypefaceHelper.typeface(helper.getTextView(R.id.app_name), App.getNew_Cicle());
                final Spring s1=AnimationUtils.getscaleOut(helper.getImageView(R.id.preivew), 0);
                final Spring s2=AnimationUtils.getscaleOut(helper.getImageView(R.id.like), 0);
                final Spring s3=AnimationUtils.getscaleOut(helper.getImageView(R.id.delete), 0);

                ((SwipeLayout)helper.getView(R.id.swipelayout)).addSwipeListener(new SimpleSwipeListener(){
                    @Override
                    public void onUpdate(SwipeLayout layout, int leftOffset, int topOffset) {
                        super.onUpdate(layout, leftOffset, topOffset);
                        s1.setEndValue((1 - (leftOffset * 0.003) - 1));
                        s2.setEndValue((1 - (leftOffset * 0.003) - 1));
                        s3.setEndValue((1-(leftOffset * 0.003)-1));
                    }
                });
            }

        };

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(new AlphaInAnimationAdapter(adapter));

        listData.add(new ProfileMessages("1 minute ago", "Mike | Creative Mints", "Mechanical Grasshoper", R.drawable.phone_icon));
        listData.add(new ProfileMessages("21 minute ago", "Dash", "Assistant App - Whether Module", R.drawable.cloud));
        listData.add(new ProfileMessages("1 hour ago", "John deo", "Upcoming web agency", R.drawable.phone_icon));
        listData.add(new ProfileMessages("2 hour ago", "Bill S Kenney", "Bamboo Branding Wall Piece - not flate", R.drawable.download));
        rv.addItemDecoration(new DividerItemDecoration(getActivity(), null));
        adapter.addAll(listData);
*/


    }


}
