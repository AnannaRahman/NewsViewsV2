package com.appwiz.newsviews.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appwiz.newsviews.R;



public class SecondSplashFragment extends Fragment {
    public static SecondSplashFragment getInstnace() {
        return new SecondSplashFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_splash, container, false);
    }
}
