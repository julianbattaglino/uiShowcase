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
import android.widget.ImageView;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

/**
 * Created by Julian Battaglino.
 */
public class FragmentBasicLogin extends Fragment {

    private ImageView imagelogin;
    private Button login;
    private View v;
    private EditText username, password;
    private TextView forgot, logo;
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
        v = localInflater.inflate(R.layout.fragment_login_1, null);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        imagelogin = getView().findViewById(R.id.imagelogin);
        login = getView().findViewById(R.id.btn_login);
        username = getView().findViewById(R.id.username);
        password = getView().findViewById(R.id.password);
        forgot = getView().findViewById(R.id.forgot_password);
        logo = getView().findViewById(R.id.logo);

        facebook = (ImageView) v.findViewById(R.id.facebook);
        instagram = (ImageView) v.findViewById(R.id.instagram);
        googleplus = (ImageView) v.findViewById(R.id.googleplus);
        sociallogin = (TextView) v.findViewById(R.id.sociallogin);


        AnimationUtils.popOut(facebook, 1200);
        AnimationUtils.popOut(instagram, 1200);
        AnimationUtils.popOut(googleplus, 1200);
        AnimationUtils.popOut(sociallogin, 1000);


        AnimationUtils.makeRoundCorner(login, Color.parseColor("#0696DC"), 15, 500);
        AnimationUtils.showMe(login, 600);
        AnimationUtils.showMe(imagelogin, 600);

        AnimationUtils.enterTop(logo, 300);
        AnimationUtils.showMe(username, 500);
        AnimationUtils.showMe(password, 500);
        AnimationUtils.enterLeft(forgot, 500);

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
