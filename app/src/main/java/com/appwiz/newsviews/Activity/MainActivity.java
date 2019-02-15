package com.appwiz.newsviews.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.appwiz.newsviews.Fragment.AppSplashFragment;
import com.appwiz.newsviews.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkSplash();
    }

    private void checkSplash() {
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean isfirstRun = getPrefs.getBoolean("firstRun", true);
        if (isfirstRun) {
            //ONLY FIRST TIME
            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
            intent.putExtra("firstRun",true);
            startActivity(intent);
            SharedPreferences.Editor e = getPrefs.edit();
            e.putBoolean("firstRun", false);
            e.apply();
        }else{
            Intent intent = new Intent(MainActivity.this, IntroActivity.class);
            intent.putExtra("firstRun",false);
            startActivity(intent);
        }
    }
}
