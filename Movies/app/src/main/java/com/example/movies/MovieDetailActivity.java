package com.example.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView imageViewPoster;
    private TextView textViewTitle, textViewYear, textViewDescription;
    private static final String EXTRA_MOVIE = "movie";
    private static final String TAG = "_MovieDetailActivity";

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initViews();

        Movie movie = (Movie)getIntent().getSerializableExtra(EXTRA_MOVIE);

        Glide.with(this)
                .load(movie.getPoster().getUrl())
                .into(imageViewPoster);
        textViewTitle.setText(movie.getName());
        textViewYear.setText(String.valueOf(movie.getYear()));
        textViewDescription.setText(movie.getDescription());

        ApiFactory.apiService.loadTrailers(movie.getId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TrailerResponse>() {

                    @Override
                    public void accept(TrailerResponse trailerResponse) throws Throwable {
                        Log.d(TAG,trailerResponse.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d(TAG,throwable.toString());
                    }
                });
    }
    private void initViews(){
        imageViewPoster = findViewById(R.id.imageViewPoster);
        textViewDescription = findViewById(R.id.textViewDescription);
        textViewYear = findViewById(R.id.textViewYear);
        textViewTitle = findViewById(R.id.textViewTitle);
    }

    public static Intent newIntent(Context context, Movie movie){
        Intent intent = new Intent(context, MovieDetailActivity.class);
        intent.putExtra(EXTRA_MOVIE,movie);
        return intent;
    }
}