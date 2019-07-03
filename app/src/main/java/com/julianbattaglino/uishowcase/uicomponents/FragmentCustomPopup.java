package com.julianbattaglino.uishowcase.uicomponents;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.julianbattaglino.uishowcase.R;

/**
 * Created by Julian Battaglino.
 */

public class FragmentCustomPopup extends Fragment {

    private Button button;

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_custom_popup_1, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button = view.findViewById(R.id.show_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                DialogCustomPopup dialogCustomPopup = new DialogCustomPopup();
                dialogCustomPopup.show(fm, DialogCustomPopup.class.getSimpleName());
            }
        });
    }
}
