package com.example.movies;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MovieDetailViewModel extends AndroidViewModel {
    public MovieDetailViewModel(@NonNull Application application) {
        super(application);
    }

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public MutableLiveData<List<Trailer>> trailers = new MutableLiveData<>();
    private static final String TAG = "_MovieDetailViewModel";

    public LiveData<List<Trailer>> getTrailers() {
        return trailers;
    }

    @SuppressLint("CheckResult")
    public void loadTrailers(int id){
        Disposable disposable = ApiFactory.apiService.loadTrailers(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<TrailerResponse>() {

                    @Override
                    public void accept(TrailerResponse trailerResponse) throws Throwable {
                        trailers.setValue(trailerResponse.getVideos().getTrailers());
                        Log.d(TAG,trailerResponse.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d(TAG,throwable.toString());
                    }
                });
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
