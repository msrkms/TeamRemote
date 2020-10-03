package com.sajidur.teamremote;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private Animation animationTop,animationBottom;
    private TextView textViewSplashTitle;
    private ImageView imageViewSplashImage;
    private static int SPLASH_TIME=2000;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        animationTop= AnimationUtils.loadAnimation(this,R.animator.splash_top_animation);
        animationBottom=AnimationUtils.loadAnimation(this,R.animator.splash_bottom_animation);
        textViewSplashTitle=findViewById(R.id.textViewTitle);
        imageViewSplashImage=findViewById(R.id.imageSplashScreen);

        imageViewSplashImage.setAnimation(animationTop);
        textViewSplashTitle.setAnimation(animationBottom);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },SPLASH_TIME);
    }
}