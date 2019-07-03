package com.julianbattaglino.uishowcase.login;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

/**
 * Created by Julian Battaglino
 **/
public class FragmentTravelLogin extends Fragment {
    private View v;
    private ImageView login;
    private EditText username, password;
    private ImageView logo;
    private ImageView facebook;
    private ImageView instagram;
    private ImageView googleplus;
    private TextView welcome;
    private TextView sociallogin;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_login_5, null);

        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        login = (ImageView) v.findViewById(R.id.login_5);
        logo = (ImageView) v.findViewById(R.id.logo);
        facebook = (ImageView) v.findViewById(R.id.facebook);
        instagram = (ImageView) v.findViewById(R.id.instagram);
        googleplus = (ImageView) v.findViewById(R.id.googleplus);
        username = (EditText) v.findViewById(R.id.username);
        password = (EditText) v.findViewById(R.id.password);
        welcome = (TextView) v.findViewById(R.id.welcome);
        sociallogin = (TextView) v.findViewById(R.id.sociallogin);

        AnimationUtils.popOut(facebook, 1200);
        AnimationUtils.popOut(instagram, 1200);
        AnimationUtils.popOut(googleplus, 1200);
        AnimationUtils.popOut(sociallogin, 1000);


        AnimationUtils.showMe(logo, 300);
        AnimationUtils.enterTop(welcome, 300);
        AnimationUtils.popOut(welcome, 300);
        AnimationUtils.enterBottom(username, 500);
        AnimationUtils.enterBottom(password, 600);
        AnimationUtils.enterBottom(login, 700);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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