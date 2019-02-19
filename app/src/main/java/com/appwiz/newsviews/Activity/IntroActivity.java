package com.appwiz.newsviews.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Window;
import android.view.WindowManager;

import com.appwiz.newsviews.Fragment.AppSplashFragment;
import com.appwiz.newsviews.Fragment.FirstSplashFragment;
import com.appwiz.newsviews.Fragment.SecondSplashFragment;
import com.appwiz.newsviews.Fragment.ThirdSplashFragment;
import com.appwiz.newsviews.R;
import com.github.paolorotolo.appintro.AppIntro;

public class IntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        boolean isFirstRun = getIntent().getBooleanExtra("firstRun", false);
        if (isFirstRun)
            splashIntro();
        else
            splasher();
    }

    private void splashIntro() {
        addSlide(FirstSplashFragment.getInstnace());
        addSlide(SecondSplashFragment.getInstnace());
        addSlide(ThirdSplashFragment.getInstnace());
        showSkipButton(false);
        setSeparatorColor(ContextCompat.getColor(this, R.color.colorAccent));
      /*setProgressButtonEnabled(true);
        setVibrate(true);
        setVibrateIntensity(30);*/
    }

    private void splasher() {
        addSlide(AppSplashFragment.getInstnace());
        showSkipButton(false);
        showSeparator(false);
        showPagerIndicator(false);
        setDoneText("");
        setSeparatorColor(ContextCompat.getColor(this, R.color.colorAccent));

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 2000);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();

    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
    }
}