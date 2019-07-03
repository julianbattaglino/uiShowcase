package com.julianbattaglino.uishowcase.login.creativelogin;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.login.LoginActivity;

/**
 * Created by Santiago Battaglino
 */
public class FragmentCreativeLogin extends Fragment {

    private View v;
    private TextView signin, signup;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_login_creative, null);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        signin = getView().findViewById(R.id.creativelogin_signin);
        signup = getView().findViewById(R.id.creativelogin_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCreativeLoginSignUp fragmentCreativeLoginSignUp = new FragmentCreativeLoginSignUp();
                ((LoginActivity) getActivity()).replaceFragment(fragmentCreativeLoginSignUp);
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCreativeLoginSignIn fragmentCreativeLoginSignIn = new FragmentCreativeLoginSignIn();
                ((LoginActivity) getActivity()).replaceFragment(fragmentCreativeLoginSignIn);
            }
        });
    }

}
