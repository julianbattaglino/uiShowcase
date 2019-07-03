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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.customviews.ArcImageView;
import com.julianbattaglino.uishowcase.model.ProfileMessages;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;
import com.julianbattaglino.uishowcase.utils.BaseAdapterHelper;
import com.julianbattaglino.uishowcase.utils.QuickAdapter;

import java.util.ArrayList;
import java.util.List;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by Julian Battaglino.
 */
public class FragmentClasicProfile extends Fragment {
    private TextView profile_name, tag1, placeholder, title, profile_name_1;
    private ImageView menu, profile_bg, img2, img3;
    private View v;
    private ArcImageView profile_image;
    private QuickAdapter<ProfileMessages> adapter;
    private RecyclerView rv;
    private List<ProfileMessages> listData = new ArrayList<>();
    private SupportAnimator animator;
    private RelativeLayout relative;
    private LinearLayout root;
    private String[] colors = {"#FF8FA4AD", "#FF788F9B", "#FF607D8B", "#FF546E7A", "#FF455A64",};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_profile_5, null);

        // //TypefaceHelper.typeface(v, App.getBlackJar());

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //((AnimationActivity) getActivity()).getMyActionBar().hide();

        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);

        profile_name = (TextView) getView().findViewById(R.id.profile_name);
        menu = (ImageView) getView().findViewById(R.id.menu);
        profile_bg = (ImageView) getView().findViewById(R.id.profile_bg_5);
        profile_image = (ArcImageView) getView().findViewById(R.id.profile_image);
        relative = (RelativeLayout) getView().findViewById(R.id.top_wrapper);
        root = (LinearLayout) getView().findViewById(R.id.root);

        tag1 = (TextView) getView().findViewById(R.id.tag1);
        placeholder = (TextView) getView().findViewById(R.id.placeholder);

        rv = (RecyclerView) getView().findViewById(R.id.rv);

        //TypefaceHelper.typeface(tag1, App.getNew_Cicle());
        //TypefaceHelper.typeface(tag1, App.getRoboto_regular());
        //TypefaceHelper.typeface(profile_name, App.getRoboto_bold());

        AnimationUtils.enterTop(profile_name, 1500);
        AnimationUtils.enterTop(tag1, 1700);

        profile_image.setBorderColor(0x55000000);
        profile_image.setBorderWidth(15);
        profile_image.setProgress(100);

       /* // get the center for the clipping circle
        final int cx = (profile_bg.getLeft() + profile_bg.getRight()) / 2;
        final int cy = (profile_bg.getTop() + profile_bg.getBottom()) / 2;

        // get the final radius for the clipping circle
        int dx = Math.max(cx, profile_bg.getWidth() - cx);
        int dy = Math.max(cy, profile_bg.getHeight() - cy);
        final float finalRadius = (float) Math.hypot(dx, dy);*/


        AnimationUtils.popOut(profile_image, 1500);

        profile_bg.postDelayed(new Runnable() {
            @Override
            public void run() {
                profile_bg.setVisibility(View.VISIBLE);
                animator = ViewAnimationUtils.createCircularReveal(profile_bg,
                        profile_bg.getRight() / 2, profile_bg.getBottom() / 2, 0,
                        AnimationUtils.hypo(profile_bg.getHeight(), profile_bg.getWidth()),
                        View.LAYER_TYPE_SOFTWARE);
                animator.setDuration(500);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();
            }
        }, 1700);

        root.postDelayed(new Runnable() {
            @Override
            public void run() {
                root.setVisibility(View.VISIBLE);
                animator = ViewAnimationUtils.createCircularReveal(root,
                        0, (int) (root.getBottom() * 0.66), 0,
                        AnimationUtils.hypo(root.getHeight(), root.getWidth()),
                        View.LAYER_TYPE_SOFTWARE);
                animator.setDuration(500);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();
            }
        }, 300);


        adapter = new QuickAdapter<ProfileMessages>(getActivity(), R.layout.row_layout_profile_5) {
            @Override
            protected void convert(final BaseAdapterHelper helper, ProfileMessages item) {

                helper.getImageView(R.id.action_img).setImageResource(item.getImage());
                helper.getTextView(R.id.action).setText(item.getFrom());
                //helper.getTextView(R.id.action).setTextColor(Color.parseColor(colors[helper.getAdapterPosition()]));


                //TypefaceHelper.typeface(helper.getTextView(R.id.action), App.getNew_Cicle());
                final View v = helper.getView(R.id.root);
                v.setBackgroundColor(Color.parseColor(colors[helper.getAdapterPosition()]));
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AnimationUtils.rotateClockWiseVisible(helper.getImageView(R.id.action_img), 100);
                        placeholder.setVisibility(View.VISIBLE);
                        int cx = (view.getLeft() + view.getRight()) / 2;
                        int cy = (view.getTop());

                        // get the final radius for the clipping circle
                        int dx = Math.max(cx, view.getWidth() - cx);
                        int dy = Math.max(cy, view.getHeight() - cy);
                        float finalRadius = (float) Math.hypot(dx, dy);


                        placeholder.setBackgroundColor(Color.parseColor(colors[helper.getAdapterPosition()]));
                        animator = ViewAnimationUtils.createCircularReveal(placeholder, cx, cy, 0,
                                finalRadius,
                                View.LAYER_TYPE_SOFTWARE);
                        animator.setDuration(500);
                        animator.setInterpolator(new AccelerateDecelerateInterpolator());
                        animator.start();
                    }
                });

            }

        };

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv.setAdapter(adapter);

        listData.add(new ProfileMessages("1 minute ago", "Perfil", "Mechanical Grasshoper", R.drawable.perfil));
        listData.add(new ProfileMessages("21 minute ago", "Diseño", "Assistant App - Whether Module", R.drawable.artpalette));
        listData.add(new ProfileMessages("1 hour ago", "Proyectos", "Upcoming web agency", R.drawable.proyectos));
        listData.add(new ProfileMessages("2 hour ago", "Fotos", "Bamboo Branding Wall Piece - not flate", R.drawable.fotos));
        listData.add(new ProfileMessages("2 hour ago", "Clientes", "Bamboo Branding Wall Piece - not flate", R.drawable.clientes));
        //rv.addItemDecoration(new DividerItemDecoration(getActivity(), null));
        adapter.addAll(listData);


    }


}
