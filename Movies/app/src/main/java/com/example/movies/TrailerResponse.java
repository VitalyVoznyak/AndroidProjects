package com.example.movies;

import com.google.gson.annotations.SerializedName;

public class TrailerResponse {
    @SerializedName("videos")
    Videos videos;

    public TrailerResponse(Videos videos) {
        this.videos = videos;
    }

    public Videos getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return "TrailerResponse{" +
                "videos=" + videos +
                '}';
    }
}
