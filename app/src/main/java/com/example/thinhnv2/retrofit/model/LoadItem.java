package com.example.thinhnv2.retrofit.model;

import com.example.thinhnv2.retrofit.model.enity.Item;

import java.util.List;

public interface LoadItem {
    void  onLoadSuccess(List<Item>item);
    void onError(String messeng);

}
