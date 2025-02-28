package com.example.project8;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Model> data;
    public static final String API_KEY = "5be2bf7eca4f4c05a8e4a75c4085031a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();

        // Initialize recyclerView here, before the null check
        recyclerView = findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        } else {
            // Handle the case where recyclerView is not found in the layout
            Toast.makeText(this, "RecyclerView not found in layout!", Toast.LENGTH_LONG).show();
            finish(); // Optionally, close the activity if critical
        }

        NewsInterface newsInterface = MyCaller.getInstance().getNewsInterface();
        Call<NewsData> call = newsInterface.getTopHeadlines("bbc", API_KEY);

        call.enqueue(new Callback<NewsData>() {
            @Override
            public void onResponse(Call<NewsData> call, Response<NewsData> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Error: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                NewsData newsData = response.body();
                if (newsData == null || newsData.getArticles() == null) {
                    Toast.makeText(MainActivity.this, "No articles found!", Toast.LENGTH_LONG).show();
                    return;
                }

                data.clear();
                for (int i = 0; i < newsData.getArticles().size(); i++) {
                    data.add(new Model(newsData.getArticles().get(i).getTitle(),
                            newsData.getArticles().get(i).getDescription(),
                            newsData.getArticles().get(i).getUrlToImage()));
                }

                if (recyclerView != null) {
                    recyclerView.setAdapter(new NewsAdapter(data, MainActivity.this));
                }
            }

            @Override
            public void onFailure(Call<NewsData> call, Throwable throwable) {
                Toast.makeText(MainActivity.this, "Error: " + throwable.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}