package com.appwiz.newsviews.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appwiz.newsviews.R;


public class AppSplashFragment extends Fragment {
    public static AppSplashFragment getInstnace() {
        return new AppSplashFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.general_splash, container, false);


        return view;
    }
}
