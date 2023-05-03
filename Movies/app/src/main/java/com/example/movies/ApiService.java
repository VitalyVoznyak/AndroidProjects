package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=QVMF4DA-60Z4378-K6Y684P-RRW3AX4&sortField=rating.kp&search=4-8&sortType=-1&limit=100")
    Single<MovieResponse> loadMovies(@Query("page") int page);
}
