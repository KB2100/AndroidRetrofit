package com.example.project8;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    @GET("v2/everything")
    Call<NewsData> getTopHeadlines(@Query("q") String sources,@Query("apiKey") String apikey);




}
