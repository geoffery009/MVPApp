package com.aaa.mvpapp.model;

import com.aaa.mvpapp.http.DataSign;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

public class MainModel<T> extends ViewModel<T> {

    @Override
    public RequestBody getNetworkData(Callback callback) {
        RequestBody body = super.getNetworkData(callback);
        Call<DataSign> call = getApiService().getHome(body);
        call.enqueue(callback);
        return body;
    }
}
