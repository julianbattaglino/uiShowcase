package com.julianbattaglino.uishowcase.login;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;

/**
 * Created by Julian Battaglino.
 */

public class FragmentMediaLogin extends Fragment implements View.OnClickListener {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login_9, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView login, register, skip;
        EditText loginText = view.findViewById(R.id.login_page_media_login_text);
        EditText passText = view.findViewById(R.id.login_page_media_login_password);
        Typeface sRobotoThin = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Roboto-Thin.ttf");
        login = view.findViewById(R.id.login);
        register = view.findViewById(R.id.register);
        skip = view.findViewById(R.id.skip);

        loginText.setTypeface(sRobotoThin);
        passText.setTypeface(sRobotoThin);

        login.setOnClickListener(this);
        register.setOnClickListener(this);
        skip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            TextView tv = (TextView) v;
            Toast.makeText(getActivity(), tv.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}