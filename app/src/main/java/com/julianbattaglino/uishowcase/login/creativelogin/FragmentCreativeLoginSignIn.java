package com.julianbattaglino.uishowcase.login.creativelogin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.login.LoginActivity;

public class FragmentCreativeLoginSignIn extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView create;
    private String mParam1;
    private String mParam2;

    private FragmentCreativeLoginSignIn.OnFragmentInteractionListener mListener;

    public FragmentCreativeLoginSignIn() {

    }

    public static FragmentCreativeLoginSignIn newInstance(String param1, String param2) {
        FragmentCreativeLoginSignIn fragment = new FragmentCreativeLoginSignIn();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_creative_signin, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        create = getView().findViewById(R.id.create);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentCreativeLoginSignUp fragmentCreativeLoginSignUp = new FragmentCreativeLoginSignUp();
                ((LoginActivity) getActivity()).replaceFragment(fragmentCreativeLoginSignUp);
            }
        });

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCreativeLoginSignIn.OnFragmentInteractionListener) {
            mListener = (FragmentCreativeLoginSignIn.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

}
