package com.example.movies;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("movie?token=QVMF4DA-60Z4378-K6Y684P-RRW3AX4&sortField=rating.kp&search=4-8&sortType=-1&limit=100")
    Single<MovieResponse> loadMovies(@Query("page") int page);

    @GET("movie?token=QVMF4DA-60Z4378-K6Y684P-RRW3AX4&field=id")
    Single<TrailerResponse> loadTrailers(@Query("search") int id);

    @GET("v1/review?token=QVMF4DA-60Z4378-K6Y684P-RRW3AX4&field=movieId")
    Single<ReviewResponse> loadReviews(@Query("search")int id );
}
//movie?token=QVMF4DA-60Z4378-K6Y684P-RRW3AX4@filed=id&search=326
//https://api.kinopoisk.dev/v1/review?token=QVMF4DA-60Z4378-K6Y684P-RRW3AX4&sortField=movieId&search=326
