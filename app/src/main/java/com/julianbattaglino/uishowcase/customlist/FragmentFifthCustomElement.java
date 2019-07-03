package com.julianbattaglino.uishowcase.customlist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.julianbattaglino.uishowcase.R;

public class FragmentFifthCustomElement extends Fragment {
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_profile3);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_fifth_constraint_sample, null);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
