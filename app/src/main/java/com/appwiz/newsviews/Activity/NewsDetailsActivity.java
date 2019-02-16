package com.appwiz.newsviews.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.appwiz.newsviews.R;

public class NewsDetailsActivity extends AppCompatActivity {
    private Bundle extras;
    private WebView webView;
    private ProgressDialog dialog;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        webView = (WebView) findViewById(R.id.wbNewsDetails);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        extras = getIntent().getExtras();
        String url = extras.getString("News Link");
        webView.getSettings().setJavaScriptEnabled(true);

        progressBar.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                super.onPageFinished(view,url);
                progressBar.setVisibility(View.GONE);
               // closeProgressView();
            }
        });
        webView.loadUrl(url);
        //showProgressView();
    }

    private void showProgressView() {
        dialog = new ProgressDialog(NewsDetailsActivity.this);
        dialog.setMessage("please wait...");
        dialog.show();

    }

    private void closeProgressView() {
        if (dialog != null && dialog.isShowing())
            dialog.dismiss();
    }
}
