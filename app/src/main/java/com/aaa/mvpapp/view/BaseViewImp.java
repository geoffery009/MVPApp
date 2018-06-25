package com.aaa.mvpapp.view;

import com.aaa.mvpapp.bean.Res;

public interface BaseViewImp<T extends Res> {

    public void showProgress();//显示进度条

    public void hideProgress();//隐藏进度条

    public void bindData(T data);//view绑定数据源

}
