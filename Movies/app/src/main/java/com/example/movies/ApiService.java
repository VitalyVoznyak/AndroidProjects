package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("movie?token=QVMF4DA-60Z4378-K6Y684P-RRW3AX4&sortField=rating.kp&search=8-10&sortType=-1&page=2&limit=5")
    Single<MovieResponse> loadMovies();
}
