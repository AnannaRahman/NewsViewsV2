package com.appwiz.newsviews.Utils;


import android.os.Handler;

import com.appwiz.newsviews.model.HeadLine;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.Result;

public class NetworkService {

    private NetworkCall networkCall = null;
    private NetworkCall networkCall2 = null;

    private Handler handler;
    public static int SUCCESS = 1;
    public static int FAILED = 0;

    public NetworkService() {
        Retrofit retrofit = RestClient.getClient();
        networkCall = retrofit.create(NetworkCall.class);
    }
    public NetworkCall NetworkServiceNumber() {
        Retrofit retrofit = RestClient.getNumberClient();
        networkCall2 = retrofit.create(NetworkCall.class);
        return networkCall2;
    }

    /*public NetworkService(Context context) {
        Retrofit retrofit = RestClient.getClient(context);
        networkCall = retrofit.create(NetworkCall.class);
    }*/

    //region GET METHODS

    public Observable<HeadLine> GetTopHeadlines(String country, String key) {

        return networkCall.GetTopHeadlines(country, key);


    }
    public Observable<ResponseBody> GetTrivialString(String num) {
        NetworkServiceNumber();
        return networkCall2.GetTrivialString(num);


    }
    public Observable<String> GetChannel() {
        return networkCall.GetChannel();
    }


    //endregion

}
