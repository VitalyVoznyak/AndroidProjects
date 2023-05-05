package com.example.movies;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Trailer {
    @SerializedName("url")
    String url;
    @SerializedName("name")
    String name;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public Trailer(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trailer{" +
                "url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
