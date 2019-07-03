package com.julianbattaglino.uishowcase.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.julianbattaglino.uishowcase.R;

public class LoginVideoSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    private static final String TAG = "INTRO_SF_VIDEO_CALLBACK";
    private MediaPlayer mp;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoginVideoSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public LoginVideoSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public LoginVideoSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoginVideoSurfaceView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mp = new MediaPlayer();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.welcomevideo);
        try {
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
            mp.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int videoWidth = mp.getVideoWidth();
        int videoHeight = mp.getVideoHeight();
        int screenHeight = getHeight();
        android.view.ViewGroup.LayoutParams lp = getLayoutParams();
        lp.height = screenHeight;
        lp.width = (int) (((float) videoWidth / (float) videoHeight) * (float) screenHeight);

        setLayoutParams(lp);
        mp.setDisplay(getHolder());
        mp.setLooping(true);
        mp.start();
        mp.setVolume(0, 0);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mp.stop();
    }

}