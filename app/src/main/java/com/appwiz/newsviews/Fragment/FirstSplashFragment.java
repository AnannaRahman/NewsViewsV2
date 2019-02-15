package com.appwiz.newsviews.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appwiz.newsviews.R;

public class FirstSplashFragment extends Fragment {


    public static FirstSplashFragment getInstnace() {
        return new FirstSplashFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_splash, container, false);
    }

}
