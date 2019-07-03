package com.julianbattaglino.uishowcase.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.julianbattaglino.uishowcase.R;
import com.julianbattaglino.uishowcase.adapters.MainAdapter;
import com.julianbattaglino.uishowcase.model.AndroidVersions;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.LandingAnimator;

/**
 * Created by Julian Battaglino.
 */
public class ActivityTransitionDemo extends AppCompatActivity {

    RecyclerView rv;
    List<AndroidVersions> listData;
    MainAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowReturnTransitionOverlap(true);
            Transition trans = new Explode();
            getWindow().setEnterTransition(trans);

            Transition returnTrans = new Slide();
            returnTrans.setDuration(2000);
            ((Slide) returnTrans).setSlideEdge(Gravity.LEFT);
            getWindow().setReturnTransition(returnTrans);
        }
        setContentView(R.layout.fragment_home);
        //TypefaceHelper.typeface(this);
        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(ActivityTransitionDemo.this, LinearLayoutManager.VERTICAL, false));
        rv.setHasFixedSize(true);
        listData = new ArrayList<>();
        listData.add(new AndroidVersions("Android Nougat", "http://i-cdn.phonearena.com/images/articles/248291-thumb/android-nougat-h1.jpg", "7.0"));
        listData.add(new AndroidVersions("Android MarshMellow", "http://androidspin.com/wp-content/uploads/2015/10/Android-6.0-Marshmallow.jpg", "6.0"));
        //listData.add(new AndroidVersions("Android Lolipop", "http://theandroidtimeline.com/wp-content/uploads/2015/06/lollipop.jpg", "5.0"));
        listData.add(new AndroidVersions("Android Kitkat", "http://theandroidtimeline.com/wp-content/uploads/2015/06/kitkat.jpg", "4.4"));
        listData.add(new AndroidVersions("Android Jellybean", "http://theandroidtimeline.com/wp-content/uploads/2015/06/jellybean.jpg", "4.1"));
        listData.add(new AndroidVersions("Android Icecream sandwich", "http://theandroidtimeline.com/wp-content/uploads/2015/06/icecream.jpg", "4.0"));
        listData.add(new AndroidVersions("Android Honeycomb", "http://theandroidtimeline.com/wp-content/uploads/2015/06/honeycomb.jpg", "3.0"));
        listData.add(new AndroidVersions("Android Gingerbread", "http://theandroidtimeline.com/wp-content/uploads/2015/06/gingerbread.jpg", "2.3"));
        listData.add(new AndroidVersions("Android Froyo", "http://theandroidtimeline.com/wp-content/uploads/2015/06/froyo.jpg", "2.2"));
        listData.add(new AndroidVersions("Android Eclairs", "http://theandroidtimeline.com/wp-content/uploads/2015/06/Eclair.jpg", "2.0"));
        listData.add(new AndroidVersions("Android Donut", "http://theandroidtimeline.com/wp-content/uploads/2015/06/Donut.jpg", "1.6"));
        listData.add(new AndroidVersions("Android Cupcake", "http://theandroidtimeline.com/wp-content/uploads/2015/06/cupcake.jpg", "1.5"));
        rv.setItemAnimator(new LandingAnimator());
        adapter = new MainAdapter(this, listData);

        rv.setAdapter(new ScaleInAnimationAdapter(adapter));

        adapter.setItemClickListener(new MainAdapter.onItemClickListener() {
            @Override
            public void onItemClicked(int position, View v, TextView text) {
                final Intent intent = new Intent(ActivityTransitionDemo.this, DetailedActivity.class);
                DetailedActivity.data = listData.get(position);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        ActivityTransitionDemo.this,
                        new Pair<View, String>(v,
                                getString(R.string.transition_name_name)), new Pair<View, String>(text,
                                getString(R.string.transition_name_title))

                );
                ActivityCompat.startActivity(ActivityTransitionDemo.this, intent, options.toBundle());
            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                adapter.add(new AndroidVersions("Android Lolipop", "http://theandroidtimeline.com/wp-content/uploads/2015/06/lollipop.jpg", "5.0"), 2);
                break;
            case R.id.action_remove:
                adapter.remove(2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
