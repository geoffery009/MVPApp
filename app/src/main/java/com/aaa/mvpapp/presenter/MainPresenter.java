package com.aaa.mvpapp.presenter;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.aaa.mvpapp.view.BaseViewImp;
import com.aaa.mvpapp.bean.MainRes;
import com.aaa.mvpapp.bean.Req;
import com.aaa.mvpapp.http.DataSign;
import com.aaa.mvpapp.http.RSA;
import com.aaa.mvpapp.model.MainModel;
import com.aaa.mvpapp.model.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.aaa.mvpapp.model.ViewModel.decodeUnicode;

public class MainPresenter implements LifecycleObserver {
    private BaseViewImp view;
    private Context mContext;
    private ViewModel viewModel;
    private boolean isActivity = true;

    public MainPresenter(BaseViewImp view, Context mContext) {
        this.view = view;
        this.mContext = mContext;
    }

    /**
     * 获取页面数据
     */
    public void getData() {
        if (isActivity) this.view.showProgress();
        viewModel = new MainModel<Req>();
        viewModel.getNetworkData(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if (!isActivity) return;
                view.hideProgress();

                if (response.isSuccessful()) {
                    DataSign result = (DataSign) response.body();
                    String data = result.getData();
                    String sign = result.getSign();
                    boolean isSign = RSA.verifySignature(data, sign);
                    if (isSign) {   //验签
                        String str = RSA.decryptData(data);
                        Log.d("test", decodeUnicode(str));

                        MainRes res = viewModel.getmGson().fromJson(str, MainRes.class);
                        if (res.getStatus().equals("2000")) {
                            view.bindData(res);
                        } else {
                            viewShowError(res.getMsg());
                        }
                    } else {
                        viewShowError("验签失败");
                    }
                } else {
                    viewShowError(response.message().toString());
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if (!isActivity) return;
                view.hideProgress();
                viewShowError(t.toString());
            }
        });
    }

    private void viewShowError(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void cancelRequest() {
        isActivity = false;
    }
}
