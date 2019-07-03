package com.julianbattaglino.uishowcase.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.model.AndroidVersions;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;
import com.squareup.picasso.Picasso;
import com.tumblr.backboard.performer.Performer;


/**
 * Created by Julian Battaglino.
 */
public class DetailedActivity extends AppCompatActivity {

    public static AndroidVersions data;
    TextView textView;
    ImageView imageView;
    Spring sx, sy, ty, sfab, sfabY;
    CardView card;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition exitTrans = new Explode();
            exitTrans.setDuration(3000);
            exitTrans.setStartDelay(1000);
            getWindow().setExitTransition(exitTrans);

            Transition enterTrans = new Slide();
            enterTrans.setDuration(3000);
            getWindow().setReenterTransition(enterTrans);
        }
        setContentView(R.layout.detailed_activity);

        textView = (TextView) findViewById(R.id.text);
        imageView = (ImageView) findViewById(R.id.image);
        card = (CardView) findViewById(R.id.card1);
        Picasso.with(this).load(data.getImage()).into(imageView);
        textView.setText(data.getTitle());

        fab = (FloatingActionButton) findViewById(R.id.fab);
        AnimationUtils.enterLeft(fab, 150);
        AnimationUtils.showMe(fab, 150);
        AnimationUtils.popOut(findViewById(R.id.card), 150);
        AnimationUtils.enterTop(card, 150);
        sfab = SpringSystem.create().createSpring().addListener(new Performer(fab, View.TRANSLATION_X));
        sfabY = SpringSystem.create().createSpring().addListener(new Performer(fab, View.ALPHA));
        sx = SpringSystem.create().createSpring().addListener(new Performer(findViewById(R.id.card), View.SCALE_X));
        sy = SpringSystem.create().createSpring().addListener(new Performer(findViewById(R.id.card), View.SCALE_Y));
        ty = SpringSystem.create().createSpring().addListener(new Performer(card, View.TRANSLATION_Y));
        ty.setCurrentValue(500);
        sx.setEndValue(1.0);
        sy.setEndValue(1.0);
        ty.setEndValue(0);
        sfab.setCurrentValue(150);

        final ScrollView sc;
        sc = (ScrollView) findViewById(R.id.scroll);
        sc.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {

            @Override
            public void onScrollChanged() {

                int scrollY = sc.getScrollY(); //for verticalScrollView
                if (200 * (float) (sc.getMaxScrollAmount() - scrollY - fab.getWidth()) / sc.getMaxScrollAmount() > 0) {
                    sfab.setEndValue(200 * (float) (sc.getMaxScrollAmount() - scrollY - fab.getWidth()) / sc.getMaxScrollAmount());
                    Log.e("IM" + sc.getScrollY(), String.valueOf(200 * (float) (sc.getMaxScrollAmount() - scrollY - fab.getWidth()) / sc.getMaxScrollAmount()));
                    sfabY.setEndValue(100 * (float) (sc.getMaxScrollAmount() - scrollY - fab.getWidth()) / sc.getMaxScrollAmount());
                }
            }
        });


    }
}
