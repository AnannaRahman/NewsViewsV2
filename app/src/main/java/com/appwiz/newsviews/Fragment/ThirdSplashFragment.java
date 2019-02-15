package com.appwiz.newsviews.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appwiz.newsviews.R;


public class ThirdSplashFragment extends Fragment {
    public static ThirdSplashFragment getInstnace() {
        return new ThirdSplashFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third_splash, container, false);
    }
}
