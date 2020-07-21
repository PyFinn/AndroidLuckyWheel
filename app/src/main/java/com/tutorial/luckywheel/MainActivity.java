package com.tutorial.luckywheel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean mButtonRotation = true;
    private static final float number = 30f;
    int mDegrees = 0, mOldDegrees = 0;
    Button mButtonStartWheel;
    ImageView mImageWheel;
    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonStartWheel = (Button) findViewById(R.id.button_start_spin);
        mImageWheel = (ImageView) findViewById(R.id.lucky_wheel);
        r = new Random();
        mButtonStartWheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonRotation){
                    mOldDegrees = mDegrees % 360;
                    mDegrees = r.nextInt(3600) + 720;
                    RotateAnimation rotateAnimation = new RotateAnimation(mOldDegrees, mDegrees,
                            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotateAnimation.setDuration(9000);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setInterpolator(new DecelerateInterpolator());
                    rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            mButtonRotation = false;
                            mButtonStartWheel.setEnabled(false);
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            mButtonRotation = true;
                            mButtonStartWheel.setEnabled(true);
                            currentNumber(360 - (mDegrees % 360));
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    mImageWheel.startAnimation(rotateAnimation);
                }
            }
        });
    }
    private String currentNumber(int degrees) {
        String text = "";

        if (degrees >= (number * 0) && degrees < (number * 1)){
            Toast toast = Toast.makeText(this, "1", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 1) && degrees < (number * 2)){
            Toast toast = Toast.makeText(this, "2", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 2) && degrees < (number * 3)){
            Toast toast = Toast.makeText(this, "3", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 3) && degrees < (number * 4)){
            Toast toast = Toast.makeText(this, "4", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 4) && degrees < (number * 5)){
            Toast toast = Toast.makeText(this, "5", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 5) && degrees < (number * 6)){
            Toast toast = Toast.makeText(this, "6", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 6) && degrees < (number * 7)){
            Toast toast = Toast.makeText(this, "7", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 7) && degrees < (number * 8)){
            Toast toast = Toast.makeText(this, "8", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 8) && degrees < (number * 9)){
            Toast toast = Toast.makeText(this, "9", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 9) && degrees < (number * 10)){
            Toast toast = Toast.makeText(this, "10", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 10) && degrees < (number * 11)){
            Toast toast = Toast.makeText(this, "11", Toast.LENGTH_LONG);
            toast.show();
        }
        if (degrees >= (number * 11) && degrees < (number * 12)){
            Toast toast = Toast.makeText(this, "12", Toast.LENGTH_LONG);
            toast.show();
        }

        return text;
    }
}
