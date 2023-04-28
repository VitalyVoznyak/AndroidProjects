package com.example.todolist;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Database;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddNoteViewModel extends AndroidViewModel {

    private NotesDao notesDao;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<Boolean> shouldCloseScreen = new MutableLiveData<>();

    public AddNoteViewModel(@NonNull Application application) {
        super(application);
        notesDao = NoteDataBase.getInstance(application).notesDao();
    }

    public void saveNote(Note note) {
         Disposable disposable = notesDao.add(note)
                .delay(5, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        Log.d("AddNoteViewModel","subscribe");
                        shouldCloseScreen.postValue(true);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public MutableLiveData<Boolean> getShouldCloseScreen() {
        return shouldCloseScreen;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
