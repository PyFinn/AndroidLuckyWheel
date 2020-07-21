package com.tutorial.luckywheel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    boolean mButtonRotation = true;
    int intNumber = 12;
    long mDegrees = 0;
    Button mButtonStartWheel;
    ImageView mImageWheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(1024);
        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonStartWheel = (Button) findViewById(R.id.button_start_spin);
        mImageWheel = (ImageView) findViewById(R.id.lucky_wheel);
        mButtonStartWheel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mButtonRotation){
                    int random_spin_degree = new Random().nextInt(360) + 3600;
                    RotateAnimation rotateAnimation = new RotateAnimation((float) mDegrees, (float) mDegrees + random_spin_degree, 1,0.5f, 1, 0.5f);
                    mDegrees = mDegrees + random_spin_degree % 360;
                    rotateAnimation.setDuration(random_spin_degree);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setInterpolator(new DecelerateInterpolator());
                    rotateAnimation.setAnimationListener(MainActivity.this);
                    mImageWheel.setAnimation(rotateAnimation);
                    mImageWheel.startAnimation(rotateAnimation);
                }
            }
        });
    }

    @Override
    public void onAnimationStart(Animation animation) {
        this.mButtonRotation = false;
        mButtonStartWheel.setEnabled(false);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast toast = Toast.makeText(this, "" + String.valueOf((int) (((double) this.intNumber) - Math.floor(((double) this.mDegrees) / ((double) this.intNumber))))+ "", Toast.LENGTH_SHORT);
        toast.show();
        this.mButtonRotation = true;
        mButtonStartWheel.setEnabled(true);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
