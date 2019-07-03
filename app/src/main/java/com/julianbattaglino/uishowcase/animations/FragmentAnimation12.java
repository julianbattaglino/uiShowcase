package com.julianbattaglino.uishowcase.animations;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

/**
 * Created by Julian Battaglino.
 */
public class FragmentAnimation12 extends Fragment {
    private boolean flag = false;
    private View v;
    private ImageView dharma;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.AppTheme_NoActionBar);

        // clone the inflater using the ContextThemeWrapper
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        v = localInflater.inflate(R.layout.fragment_animation_12, null);

//        ////TypefaceHelper.typeface(v, App.getHelveticaNeueArabic());
        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //((MainActivity) getActivity()).getMyActionBar().hide();

      /*  image = (ImageView) getView().findViewById(R.id.image);
        image.postDelayed(new Runnable() {
            @Override
            public void run() {
                Picasso.with(getActivity()).load(R.drawable.trans).into(image);
               // image.setBackgroundResource(R.drawable.profile_image_2);
            }
        }, 200);
*/
        dharma = getView().findViewById(R.id.dharma);


        AnimationUtils.enterTop(dharma, 800);
    }
}
