package com.julianbattaglino.uishowcase.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;

/**
 * Created by Julian Battaglino.
 */

public class FragmentDarkLogin extends Fragment implements View.OnClickListener {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login_8, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView login, register, skip;
        login = view.findViewById(R.id.login);
        register = view.findViewById(R.id.register);
        skip = view.findViewById(R.id.skip);

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
