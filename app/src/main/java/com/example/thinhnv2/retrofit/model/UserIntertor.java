package com.example.thinhnv2.retrofit.model;

import android.util.Log;

import com.example.thinhnv2.retrofit.model.enity.SOAnswersResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserIntertor {
    private LoadItem loadItem;
    private SOService soService;


    public UserIntertor(LoadItem loadItem) {
        this.loadItem = loadItem;
    }

    public void getData(){
        soService= ApiUtils.getSOService();
        soService.getAnswers("android").enqueue(new Callback<SOAnswersResponse>() {
            @Override
            public void onResponse(Call<SOAnswersResponse> call, Response<SOAnswersResponse> response) {
                if(response.isSuccessful()) {
                    loadItem.onLoadSuccess(response.body().getItems());
                    Log.d("MainActivity", "posts loaded from API");
                }else {
                    int statusCode  = response.code();
                    loadItem.onError(statusCode+"");
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<SOAnswersResponse> call, Throwable t) {

            }
        });
    }

}
