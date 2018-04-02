package com.example.thinhnv2.retrofit.presenter;

import com.example.thinhnv2.retrofit.model.LoadItem;
import com.example.thinhnv2.retrofit.model.UserIntertor;
import com.example.thinhnv2.retrofit.model.enity.Item;
import com.example.thinhnv2.retrofit.view.MainView;

import java.util.List;

public class MainPresenter implements LoadItem {
    private UserIntertor userIntertor;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        userIntertor=new UserIntertor(this);
        this.mainView = mainView;
    }

    public void loadData(){
        userIntertor.getData();
    }

    @Override
    public void onLoadSuccess(List<Item> item) {
        mainView.onSuccess(item);
    }

    @Override
    public void onError(String messeng) {

    }
}
