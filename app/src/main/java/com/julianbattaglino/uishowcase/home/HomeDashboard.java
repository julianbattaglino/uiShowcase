package com.julianbattaglino.uishowcase.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.animations.AnimationActivity;
import com.julianbattaglino.uishowcase.login.LoginActivity;
import com.julianbattaglino.uishowcase.profile.ProfileActivity;
import com.julianbattaglino.uishowcase.splash.SplashActivity;
import com.julianbattaglino.uishowcase.uicomponents.UiComponentsActivity;

public class HomeDashboard extends AppCompatActivity {

    private CardView splashScreenButton;
    private CardView loginScreenButton;
    private CardView profileScreenButton;
    private CardView listsScreenButton;
    private CardView aninmationsScreenButton;
    private CardView othersScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dashboard);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);

        bindViews();

        doAnimations();
    }

    private void doAnimations() {

    }

    private void bindViews() {

        // go to splash examples
        splashScreenButton = findViewById(R.id.splash_screen_card);
        splashScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context = splashScreenButton.getContext();
                context.startActivity(new Intent(context, SplashActivity.class));
            }
        });

        // go to login examples
        loginScreenButton = findViewById(R.id.login_screen_card);
        loginScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context = loginScreenButton.getContext();
                context.startActivity(new Intent(context, LoginActivity.class));
            }
        });

        // go to profile examples
        profileScreenButton = findViewById(R.id.profile_screen_card);
        profileScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context = profileScreenButton.getContext();
                context.startActivity(new Intent(context, ProfileActivity.class));
            }
        });

        // go to lists examples
        listsScreenButton = findViewById(R.id.lists_screen_card);
        listsScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context = listsScreenButton.getContext();
                // context.startActivity(new Intent(context, ListActivity.class));
                Toast.makeText(context, "Listas En Construccion, Proximamente", Toast.LENGTH_SHORT).show();
            }
        });

        // go to animations examples
        aninmationsScreenButton = findViewById(R.id.animations_screen_card);
        aninmationsScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context = aninmationsScreenButton.getContext();
                context.startActivity(new Intent(context, AnimationActivity.class));
            }
        });

        // go to others examples
        othersScreenButton = findViewById(R.id.others_ui_screen_card);
        othersScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Context context = othersScreenButton.getContext();
                context.startActivity(new Intent(context, UiComponentsActivity.class));
                //  context.startActivity(new Intent(context, CustomComponentsListActivity.class));
            }
        });
    }
}
