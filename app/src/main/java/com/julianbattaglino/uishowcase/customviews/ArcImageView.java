package com.julianbattaglino.uishowcase.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.annotation.ColorInt;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;

import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;

public class ArcImageView extends CircleImageView {

    public Handler uiThread = new Handler();
    RectF mRect;
    Paint mOutlinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    SimpleSpringListener listner;
    Canvas canvas;
    Spring s, r;
    boolean is_animate = true;
    boolean enableRotation = false;
    int arcVal;
    private int mStrockColor = 0xAA000000;
    private int mArcWidth = 2;

    public ArcImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public ArcImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        listner = new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                Log.e("D", spring.getCurrentValue() + "");

                arcVal = (int) (spring.getCurrentValue());
                uiThread.post(new Runnable() {
                    @Override
                    public void run() {
                        invalidate();
                    }
                });
            }

            @Override
            public void onSpringAtRest(Spring spring) {
                super.onSpringAtRest(spring);
                if (isEnableRotation()) {
                    if (spring.getCurrentValue() == 360.0)
                        r.setEndValue(1);
                    else
                        r.setEndValue(0);
                }
                if (spring.getCurrentValue() == 360.0) {
                    is_animate = false;
                } else if (spring.getCurrentValue() == 0) {
                    is_animate = true;
                }
            }


        };
        s = SpringSystem.create().createSpring();
        s.setCurrentValue(0);
        s.addListener(listner);

        r = SpringSystem.create().createSpring();
        r.setCurrentValue(0);
        r.addListener(new SimpleSpringListener() {
            @Override
            public void onSpringUpdate(Spring spring) {
                super.onSpringUpdate(spring);
                ViewCompat.setRotationY(ArcImageView.this, (float) 360 * (float) (spring.getCurrentValue()));
            }
        });

    }

    public ArcImageView(Context context) {
        super(context);
        // setBorderOverlay(true);
    }

    public boolean isEnableRotation() {
        return enableRotation;
    }

    public void setEnableRotation(boolean enableRotation) {
        this.enableRotation = enableRotation;
    }

    @Override
    public void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawLine(10, 10, 90, 10, paint);
        this.canvas = canvas;
        mRect = getmArcRect();
        mOutlinePaint.setStyle(Paint.Style.STROKE);
        mOutlinePaint.setStrokeWidth(mArcWidth);

        mOutlinePaint.setColor(mStrockColor);
        canvas.drawArc(mRect, 0, (int) arcVal, false, mOutlinePaint);

    }

    public void toogleValue() {
        if (is_animate) {
            s.setEndValue(360);

        } else {
            s.setEndValue(0);

        }

    }

    @Override
    public void setBorderColor(@ColorInt int borderColor) {
        //super.setBorderColor(borderColor);
        mStrockColor = borderColor;
        invalidate();
    }

    @Override
    public void setBorderWidth(int borderWidth) {
        //super.setBorderWidth(borderWidth);
        setmArcWidth(borderWidth);
        mArcWidth = borderWidth;
        invalidate();
    }

    public void setProgress(final float progress) {
        uiThread.postDelayed(new Runnable() {
            @Override
            public void run() {
                s.setEndValue(progress * 360f / 100);
            }
        }, 500);

    }


}