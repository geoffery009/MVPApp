package com.aaa.mvpapp.http;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST(Api.API_HOME)
    Call<DataSign> getHome(@Body RequestBody body);
}
