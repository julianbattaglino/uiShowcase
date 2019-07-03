package com.julianbattaglino.uishowcase.login.creativelogin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.login.LoginActivity;

public class FragmentCreativeLoginSignUp extends Fragment {

    TextView signinhere;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_creative_signup, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        signinhere = getView().findViewById(R.id.signinhere);

        signinhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCreativeLoginSignIn fragmentCreativeLoginSignIn = new FragmentCreativeLoginSignIn();
                ((LoginActivity) getActivity()).replaceFragment(fragmentCreativeLoginSignIn);
            }
        });

    }

}
