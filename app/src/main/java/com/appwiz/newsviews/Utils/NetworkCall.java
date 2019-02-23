package com.appwiz.newsviews.Utils;

import com.appwiz.newsviews.model.HeadLine;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface NetworkCall {

    //region GET
    @GET("v2/top-headlines")
    Observable<HeadLine> GetTopHeadlines(@Query("country") String country, @Query("apiKey") String apiKey);

    @GET("aplservice/GetChannel")
    Observable<String> GetChannel();

    @GET("{number}/trivia")
    Observable<ResponseBody> GetTrivialString(@Path("number")String number);



    //endregion
}
