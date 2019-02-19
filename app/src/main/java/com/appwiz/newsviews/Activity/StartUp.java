package com.appwiz.newsviews.Activity;

import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.appwiz.newsviews.R;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class StartUp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        checkSplash();
    }

    private void checkSplash() {
        SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean isfirstRun = getPrefs.getBoolean("firstRun", true);
        if (isfirstRun) {
            //ONLY FIRST TIME
            Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
            intent.putExtra("firstRun", true);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            SharedPreferences.Editor e = getPrefs.edit();
            e.putBoolean("firstRun", false);
            e.apply();
        } else {
            Intent intent = new Intent(getApplicationContext(), IntroActivity.class);
            intent.putExtra("firstRun", false);
            intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
