package com.julianbattaglino.uishowcase.login;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.rebound.Spring;
import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.customviews.ArcImageView;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

/**
 * Created by Julian Battaglino.
 */
public class FragmentModernLogin extends Fragment {
    private View v;
    private ArcImageView image;
    private TextView forgot, title;
    private LinearLayout login_wrapper_3;
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
        v = localInflater.inflate(R.layout.fragment_login_3, null);

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        forgot = (TextView) getView().findViewById(R.id.forgot_password);
        title = (TextView) getView().findViewById(R.id.title);

        login = (Button) getView().findViewById(R.id.btn_login);
        username = (EditText) getView().findViewById(R.id.username);
        password = (EditText) getView().findViewById(R.id.password);
        login_wrapper_3 = (LinearLayout) getView().findViewById(R.id.wrapper_3);

        AnimationUtils.makeRoundCorner(login, Color.parseColor("#14132f"), 10, 1500);
        AnimationUtils.enterBottom(login, 1200);
        AnimationUtils.landMe(login, 2000);


        AnimationUtils.enterTop(title, 900);
        AnimationUtils.showMe(title, 900);
        AnimationUtils.rotateXwithColor(title, Color.parseColor("#66FFFFFF"), 1000);
        AnimationUtils.rotateXwithColor(title, Color.parseColor("#14132f"), 2000);
        AnimationUtils.landMe(title, 2500);

        AnimationUtils.landMeX(login_wrapper_3, 500);

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
