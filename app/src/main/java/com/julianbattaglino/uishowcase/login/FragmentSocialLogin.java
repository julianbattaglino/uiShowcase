package com.julianbattaglino.uishowcase.login;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringSystem;
import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.customviews.ArcImageView;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;

/**
 * Created by Julian Battaglino.
 */
public class FragmentSocialLogin extends Fragment {
    private View v;
    private ArcImageView image;
    private ImageView card;
    private LinearLayout bg_profile, signup_wrapper;
    private TextView name, address, title;
    private RelativeLayout login_wrapper_2;
    private EditText username, password;
    private Button login;
    private Spring sw;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_login_2, null);

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        name = (TextView) getView().findViewById(R.id.name);
        address = (TextView) getView().findViewById(R.id.address);
        title = (TextView) getView().findViewById(R.id.title);

        login = (Button) getView().findViewById(R.id.btn_login);
        username = (EditText) getView().findViewById(R.id.username);
        password = (EditText) getView().findViewById(R.id.password);

        image = (ArcImageView) getView().findViewById(R.id.image);
        card = (ImageView) getView().findViewById(R.id.card);
        login_wrapper_2 = (RelativeLayout) getView().findViewById(R.id.login_wrapper_2);
        signup_wrapper = (LinearLayout) getView().findViewById(R.id.signup_wrapper);

        AnimationUtils.enterBottom(name, 800);
        AnimationUtils.enterBottom(address, 900);
        AnimationUtils.enterBottom(username, 1000);
        AnimationUtils.enterBottom(password, 1100);
        AnimationUtils.enterBottom(card, 1200);
        AnimationUtils.enterBottom(login, 1200);
        AnimationUtils.enterBottom(signup_wrapper, 1300);
        AnimationUtils.landMe(signup_wrapper, 1400);

        AnimationUtils.enterTop(title, 900);
        AnimationUtils.showMe(title, 900);


        bg_profile = (LinearLayout) getView().findViewById(R.id.bg_profile);

        image.setBorderColor(Color.WHITE);
        image.setBorderWidth(3);

        AnimationUtils.popOut(image, 400);


        login_wrapper_2.postDelayed(new Runnable() {
            @Override
            public void run() {
                login_wrapper_2.setVisibility(View.VISIBLE);
                int cx = (bg_profile.getLeft() + bg_profile.getRight()) / 2;
                int cy = (bg_profile.getTop() + bg_profile.getBottom()) / 2;

                // get the final radius for the clipping circle
                int dx = Math.max(cx, bg_profile.getWidth() - cx);
                int dy = Math.max(cy, bg_profile.getHeight() - cy);
                float finalRadius = (float) Math.hypot(dx, dy);
                SupportAnimator animator = ViewAnimationUtils.createCircularReveal(login_wrapper_2,
                        cx, cy, 0,
                        finalRadius,
                        View.LAYER_TYPE_SOFTWARE);
                animator.setDuration(700);

                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();

                animator.addListener(new SupportAnimator.AnimatorListener() {
                    @Override
                    public void onAnimationStart() {

                    }

                    @Override
                    public void onAnimationEnd() {
                        sw.setEndValue((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 110, getResources().getDisplayMetrics()));
                    }

                    @Override
                    public void onAnimationCancel() {

                    }

                    @Override
                    public void onAnimationRepeat() {

                    }
                });
            }
        }, 300);


        SpringConfig.defaultConfig = SpringConfig.fromBouncinessAndSpeed(12, 35);

        sw = SpringSystem.create().createSpring();

        AnimationUtils.makeRoundCorner(bg_profile, Color.parseColor("#FF62374e"), 50, 1000);


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


            }
        });

        bg_profile.postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, 500);

        username.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == android.view.KeyEvent.ACTION_UP) {
                    switch (keyCode) {
                        case android.view.KeyEvent.KEYCODE_DPAD_CENTER:
                        case android.view.KeyEvent.KEYCODE_ENTER:
                            jumpToPassword();
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
    }

    private void jumpToPassword() {
        password.requestFocus();
    }

}
