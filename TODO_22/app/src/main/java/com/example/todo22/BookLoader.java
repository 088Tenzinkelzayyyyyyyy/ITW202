package com.example.todo22;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader<String> {
    private String mQueryString;
    BookLoader(Context context, String queryString){
        super(context);
        mQueryString = queryString;
    }

    public BookLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
    @Override
    protected void onStartLoading(){
        super.onStartLoading();
        forceLoad();
    }
}
