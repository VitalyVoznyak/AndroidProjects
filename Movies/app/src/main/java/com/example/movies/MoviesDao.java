package com.example.movies;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;

@Dao
public interface MoviesDao {

    @Query("SELECT * FROM favouriteMovies")
    LiveData<List<Movie>> getAllFavouriteMovies();

    @Query("SELECT * FROM favouriteMovies WHERE id = :movieId")
    LiveData<Movie> getFavouriteMovie(int movieId);

    @Insert //(onConflict = OnConflictStrategy.IGNORE)
    Completable insertMovie(Movie movie);

    @Query("DELETE FROM favouriteMovies WHERE id = :movieId")
    Completable removeMovie(int movieId);
}
