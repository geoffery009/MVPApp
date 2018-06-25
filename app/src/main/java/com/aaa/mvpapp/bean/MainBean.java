package com.aaa.mvpapp.bean;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

/**
 * 页面显示数据封装类
 */
public class MainBean extends BaseObservable {
    //set时即时更新页面数据
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> phone = new ObservableField<>();

    public MainBean(String name) {
        this.name.set(name);
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
