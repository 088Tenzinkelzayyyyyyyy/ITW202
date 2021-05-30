package com.example.todo22;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    private TextView mTitleText, mAuthorText;
    private EditText mBookInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = findViewById(R.id.book_input);
        mTitleText = findViewById(R.id.instruct);
        mAuthorText = findViewById(R.id.author_text);

        if (getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null,this);
        }

    }
    public void searchBooks(View view){
        String queryString = mBookInput.getText().toString();

        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connectivityManager != null){
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && queryString.length() != 0){
            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString",queryString);
            getSupportLoaderManager().restartLoader(0,queryBundle,this);
//            new FetchBooks(mTitleText,mAuthorText).execute(queryString);
            mAuthorText.setText("");
            mTitleText.setText("Loading.......");

        }
        else {
            if (queryString.length() == 0){
                mTitleText.setText("");
                mAuthorText.setText("Please enter search item");
            }else {
                mTitleText.setText("");
                mAuthorText.setText("Please check your connection");
            }

        }
    }


    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";
        if (args != null){
            queryString = args.getString("queryString");
        }
        return new BookLoader(this,queryString);

    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray itemsArray = jsonObject.getJSONArray("items");
            int i = 0;
            String title = null;
            String authors = null;
            while (i < itemsArray.length() && (authors == null && title == null)) {
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
                mTitleText.setText(title);
                mAuthorText.setText(authors);
            }
            else {
                mTitleText.setText("No results for this.");
                mAuthorText.setText("");
            }

        } catch (JSONException e) {
            mTitleText.setText("No results for this.");
            mAuthorText.setText("");
            e.printStackTrace();
        }

        }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}