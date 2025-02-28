package com.example.project8;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyCaller {
    Retrofit retrofit;

    public static MyCaller instance;
    String baseurl = "https://newsapi.org/";

    private MyCaller() {
        retrofit=  new Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static MyCaller getInstance() {
        if(instance == null) {
            instance = new MyCaller();
            return instance;
        } else {
            return instance;

        }
    }

    public  NewsInterface getNewsInterface(){
         return retrofit.create(NewsInterface.class);
    }
}