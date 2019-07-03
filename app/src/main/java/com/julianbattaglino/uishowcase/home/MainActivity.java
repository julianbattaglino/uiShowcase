package com.julianbattaglino.uishowcase.home;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.activity.ActivityTransitionDemo;
import com.julianbattaglino.uishowcase.fragments.FragmentCard;
import com.julianbattaglino.uishowcase.login.FragmentBasicLogin;
import com.julianbattaglino.uishowcase.login.FragmentModernLogin;
import com.julianbattaglino.uishowcase.login.FragmentSocialLogin;
import com.julianbattaglino.uishowcase.login.FragmentTravelLogin;
import com.julianbattaglino.uishowcase.login.FragmentVideoLogin;
import com.julianbattaglino.uishowcase.model.DummyContent;
import com.julianbattaglino.uishowcase.profile.FragmentBasicProfile;
import com.julianbattaglino.uishowcase.profile.FragmentClasicProfile;
import com.julianbattaglino.uishowcase.profile.FragmentModernProfile;
import com.julianbattaglino.uishowcase.profile.FragmentSocialProfile;
import com.julianbattaglino.uishowcase.profile.FragmentTravelProfile;
import com.julianbattaglino.uishowcase.utils.AnimationUtils;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentCard
        .OnListFragmentInteractionListener {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    NavigationView navigationView;
    private String backStateName;
    private View mLastViewTouched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // fab.hide();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // fab.show();
            }


        };
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //TypefaceHelper.typeface(navigationView, App.getBlackJar());

        changeFragment(new FragmentCard());


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
            } else {
                super.onBackPressed();
            }

        }
    }


    public void changeFragment(Fragment f) {
        backStateName = f.getClass().getName();
        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager
                .popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentTransaction ft = manager.beginTransaction();

            ft.replace(R.id.content, f, backStateName);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camara) {
            // Handle the camera action
            changeFragment(new FragmentTravelProfile());
        } else if (id == R.id.nav_gallery) {
            changeFragment(new FragmentSocialProfile());
        } else if (id == R.id.nav_slideshow) {
            changeFragment(new FragmentBasicProfile());
        } else if (id == R.id.nav_profile4) {
            changeFragment(new FragmentModernProfile());
        } else if (id == R.id.nav_profile5) {
            changeFragment(new FragmentClasicProfile());
        } else if (id == R.id.nav_login1) {
            changeFragment(new FragmentBasicLogin());
        } else if (id == R.id.nav_login2) {
            changeFragment(new FragmentSocialLogin());
        } else if (id == R.id.nav_login3) {
            changeFragment(new FragmentModernLogin());
        } else if (id == R.id.nav_login4) {
            changeFragment(new FragmentVideoLogin());
        } else if (id == R.id.nav_login5) {
            changeFragment(new FragmentTravelLogin());
        } else if (id == R.id.list_1) {
            startActivity(new Intent(MainActivity.this, ActivityTransitionDemo.class));
        } else if (id == R.id.nav_home) {
            changeFragment(new FragmentCard());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public android.support.v7.app.ActionBar getMyActionBar() {
        return getSupportActionBar();
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item, View mView, TextView mIdView, CardView mButton) {
        switch (item.id) {
            case "6":
                AnimationUtils.popIn(mView, 100);
                break;
            case "7":
                AnimationUtils.popOut(mView, 100);
                break;
            case "8":
                AnimationUtils.enterLeft(mView, 100);
                break;
            case "9":
                AnimationUtils.enterRight(mView, 100);
                break;
            case "10":
                AnimationUtils.enterBottom(mView, 100);
                break;
            case "11":
                AnimationUtils.enterTop(mView, 100);
                break;
            case "12":
                AnimationUtils.hideMe(mView, 100);
                break;
            case "13":
                AnimationUtils.showMe(mView, 100);
                break;
            case "14":
                AnimationUtils.rotateX(mView, 100);
                break;
            case "15":
                AnimationUtils.rotateY(mView, 100);
                break;
            case "16":
                AnimationUtils.rotateClockWise(mView, 100);
                break;
            case "17":
                AnimationUtils.rotateAntiClockWise(mView, 100);
                break;
            case "18":
                AnimationUtils.setCount(mIdView, 100, " Likes");
                break;
            case "19":
                AnimationUtils.makeRoundCorner(mView, Color.CYAN, 25, 100);
                break;
            case "20":
                AnimationUtils.landMeX(mView, 100);
                break;
            case "21":
                AnimationUtils.landMeY(mView, 100);
                break;
            case "22":
                AnimationUtils.landMe(mView, 100);
                break;
            case "23":
                Random r = new Random();
                AnimationUtils.changeBound(MainActivity.this, mButton, (r.nextInt(mButton.getWidth() - 100) + 100), (r.nextInt(mButton.getWidth() - 100) + 100));
                break;

        }

    }
}
