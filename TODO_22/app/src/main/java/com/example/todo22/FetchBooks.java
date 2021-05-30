package com.example.todo22;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class FetchBooks extends AsyncTask<String, Void, String> {
    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;

    FetchBooks(TextView titleText, TextView authorText) {
        this.mTitleText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);

    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemsArray.length()&&(authors == null && title == null)){
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i++;

            }
            if (title != null && authors != null ){
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);
            }
            else {
                mTitleText.get().setText("No results for this.");
                mAuthorText.get().setText("");
            }

        } catch (JSONException e) {
            mTitleText.get().setText("No results for this.");
            mAuthorText.get().setText("");
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }
}
