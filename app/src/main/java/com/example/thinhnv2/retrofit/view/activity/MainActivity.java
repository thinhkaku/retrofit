package com.example.thinhnv2.retrofit.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.thinhnv2.retrofit.R;
import com.example.thinhnv2.retrofit.view.MainView;
import com.example.thinhnv2.retrofit.view.adapter.AnswersAdapter;
import com.example.thinhnv2.retrofit.model.enity.Item;
import com.example.thinhnv2.retrofit.presenter.MainPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView recyclerOwner;
    private MainPresenter mainPresenter;
    private AnswersAdapter answersAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadAnser();
    }

    private void loadAnser() {

    }

    private void initView() {
        mainPresenter=new MainPresenter(this);
        mainPresenter.loadData();
        recyclerOwner=findViewById(R.id.recycleOwner);
        answersAdapter=new AnswersAdapter(MainActivity.this, new ArrayList<Item>(0), new AnswersAdapter.PostItemListener() {
            @Override
            public void onPostClick(long id) {
                Toast.makeText(MainActivity.this, "Post id is" + id, Toast.LENGTH_SHORT).show();
            }
        });
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerOwner.setLayoutManager(layoutManager);
        recyclerOwner.setAdapter(answersAdapter);
        recyclerOwner.setHasFixedSize(true);
        RecyclerView.ItemDecoration decoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerOwner.addItemDecoration(decoration);
    }

    @Override
    public void onSuccess(List<Item> items) {
        answersAdapter.updateAnswers(items);
    }
}
