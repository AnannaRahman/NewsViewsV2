package com.appwiz.newsviews.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.appwiz.newsviews.R;

public class SearchResultActivity extends AppCompatActivity {

    private Bundle numberResult;
    private TextView tvSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        tvSearchResult =  findViewById(R.id.tvSearchResult);
        //numberResult = getIntent().getExtras();
        String datadata = getIntent().getStringExtra("NumberResult");
        tvSearchResult.setText(datadata);

    }
}
