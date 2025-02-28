package com.example.project8;

import java.util.ArrayList;

public class Model {

    String title, description,urlToImage;

    public Model(String title, String description, String urlToImage) {
        this.title = title;
        this.description = description;
        this.urlToImage = urlToImage;

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
