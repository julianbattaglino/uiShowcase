package com.julianbattaglino.uishowcase.login;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by Julian Battaglino.
 */
public class FragmentVideoLogin extends Fragment {
    View v;

    Button login;
    LinearLayout login_wrapper;
    ConstraintLayout login_wrapper_1;

    SurfaceView mSurfaceView = null;
    FrameLayout frame;
    ImageView close, overlay;
    RelativeLayout root;
    private Button login_btn;

    private ImageView facebook;
    private ImageView instagram;
    private ImageView googleplus;
    private TextView sociallogin;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_login_4, null);

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        frame = (FrameLayout) getView().findViewById(R.id.home_container);
        root = (RelativeLayout) getView().findViewById(R.id.root);


        login = (Button) v.findViewById(R.id.login);
        close = (ImageView) v.findViewById(R.id.close_btn);
        overlay = (ImageView) v.findViewById(R.id.overlay);
        login_btn = (Button) v.findViewById(R.id.btn_login_4);

        facebook = (ImageView) v.findViewById(R.id.facebook);
        instagram = (ImageView) v.findViewById(R.id.instagram);
        googleplus = (ImageView) v.findViewById(R.id.googleplus);
        sociallogin = (TextView) v.findViewById(R.id.sociallogin);


        login_wrapper = (LinearLayout) getView().findViewById(R.id.login_wrapper_4);
        login_wrapper_1 = (ConstraintLayout) getView().findViewById(R.id.login_wrapper_4_1);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //frame.setForeground(new ColorDrawable());
                int[] p = new int[2];
                login.getLocationOnScreen(p);
                int cx = p[0] + login.getWidth() / 2;
                int cy = p[1] + login.getHeight() / 2;

                // get the final radius for the clipping circle
                int dx = Math.max(cx, login.getWidth() - cx);
                int dy = Math.max(cy, login.getHeight() - cy);
                float finalRadius = (float) Math.hypot(dx, dy);
                SupportAnimator animator = ViewAnimationUtils.createCircularReveal(root,
                        cx, cy, 0,
                        finalRadius,
                        View.LAYER_TYPE_SOFTWARE);
                animator.setDuration(400);

                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();
                overlay.setVisibility(View.VISIBLE);
                overlay.setBackgroundColor(Color.parseColor("#99000000"));
                AnimationUtils.showMe(login_wrapper_1, 100);
                AnimationUtils.landMeX(login_wrapper_1, 100);
                AnimationUtils.makeRoundCorner(login_btn, getResources().getColor(R.color.colorPrimary), 15, 100);

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //frame.setForeground(new ColorDrawable(Color.parseColor("#33333333")));
                overlay.setBackgroundColor(Color.parseColor("#33000000"));
                AnimationUtils.hideMe(login_wrapper_1, 100);

                int[] p = new int[2];
                close.getLocationOnScreen(p);
                int cx = p[0] + close.getWidth() / 2;
                int cy = p[1] + close.getHeight() / 2;

                // get the final radius for the clipping circle
                int dx = Math.max(cx, close.getWidth() - cx);
                int dy = Math.max(cy, close.getHeight() - cy);
                float finalRadius = (float) Math.hypot(dx, dy);
                SupportAnimator animator = ViewAnimationUtils.createCircularReveal(root,
                        cx, cy, 0,
                        finalRadius,
                        View.LAYER_TYPE_SOFTWARE);
                animator.setDuration(400);

                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();


            }
        });

        AnimationUtils.enterBottom(login_wrapper, 500);
        mSurfaceView = (SurfaceView) getView().findViewById(R.id.surfaceLogin);
        mSurfaceView.invalidate();

    }


}
