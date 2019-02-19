package com.appwiz.newsviews.Fragment;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.appwiz.newsviews.R;

public class FirstSplashFragment extends Fragment {


    public static FirstSplashFragment getInstnace() {
        return new FirstSplashFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first_splash, container, false);
        return v;
    }

}
