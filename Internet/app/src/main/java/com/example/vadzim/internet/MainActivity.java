package com.example.vadzim.internet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vadzim.internet.api.UmoriliApi;
import com.example.vadzim.internet.dto.Example;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private Button button;
    private RecyclerView_Adapter recyclerView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView_adapter = new RecyclerView_Adapter();
        recyclerView.setAdapter(recyclerView_adapter);
        setListener();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.posts_recycle_view);
        button = findViewById(R.id.btn_do);
    }

    private void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doRequest();
            }
        });
    }

    private void doRequest() {
        App.getApi().getData(UmoriliApi.SOURCES, UmoriliApi.API_KEY)
                .enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        recyclerView_adapter.setPosts(response.body().getArticles());
                        recyclerView_adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "onResponse", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "onFailure", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
