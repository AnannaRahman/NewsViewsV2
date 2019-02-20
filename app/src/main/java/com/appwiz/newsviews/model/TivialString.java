package com.appwiz.newsviews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TivialString {
    @SerializedName("quote")
    @Expose
    private String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
