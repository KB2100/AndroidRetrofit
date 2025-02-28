package com.example.project8;

import java.util.ArrayList;

public class NewsData {
    int totalResults;
    String status;

    ArrayList<Model> articles;


    public NewsData(int totalResults, String status, ArrayList<Model> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;


    }

    public int getTotalResults() {
        return totalResults;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }
}
