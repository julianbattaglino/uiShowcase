package com.julianbattaglino.uishowcase.welcomescreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.home.HomeDashboard;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Julian Battaglino
 * We use here the AnimationUtils from android sdk.
 */

public class WelcomeActivity extends AppCompatActivity {

    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 10000;
    FrameLayout frame;
    SurfaceView mSurfaceView = null;
    private LinearLayout l1, l2;
    private Animation uptodown, downtoup;
    private TextView btnsub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnsub = findViewById(R.id.buttonsub);
        l1 = (LinearLayout) findViewById(R.id.l1);
        frame = (FrameLayout) findViewById(R.id.home_container);


        uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
        l1.setAnimation(uptodown);


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                Intent mainIntent = new Intent().setClass(WelcomeActivity.this, HomeDashboard.class);
                mainIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(mainIntent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);

        mSurfaceView = (SurfaceView) findViewById(R.id.introsurface);
        mSurfaceView.invalidate();

    }


}
