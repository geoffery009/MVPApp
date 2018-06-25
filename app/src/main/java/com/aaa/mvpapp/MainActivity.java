package com.aaa.mvpapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aaa.mvpapp.bean.MainRes;
import com.aaa.mvpapp.bean.MainBean;
import com.aaa.mvpapp.databinding.ActivityMainBinding;
import com.aaa.mvpapp.presenter.MainPresenter;
import com.aaa.mvpapp.view.BaseViewImp;

import androidx.navigation.Navigation;

public class MainActivity extends AppCompatActivity implements BaseViewImp<MainRes> {
    private ActivityMainBinding binding;
    private MainPresenter presenter;
    private MainBean showBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main);
        showBean = new MainBean("text");
        binding.setBean(showBean);
        presenter = new MainPresenter(this, this);
        //add lifecycle
        getLifecycle().addObserver(presenter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void bindData(MainRes data) {
        if (data == null) return;
        showBean.setName(data.getData().getAllcount());
    }

    public void get(View view) {
        presenter.getData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp();
    }
}
