package com.example.todo_8_i;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

public class MainActivity extends AppCompatActivity {
    private EditText mEdttxt1;
    private EditText mEdttxt2;
    private EditText mEdttxt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdttxt1 = findViewById(R.id.edit_text1);
        mEdttxt2 = findViewById(R.id.edit_text2);
        mEdttxt3 = findViewById(R.id.edit_text3);
    }

    public void openWebsite(View view) {
        String webpage = mEdttxt1.getText().toString();
        Uri url = Uri.parse(webpage);
        Intent intent = new Intent(Intent.ACTION_VIEW, url);
        //if (intent.resolveActivity(getPackageManager()) != null){
        startActivity(intent);
        // }
        //else {
        //    Log.d("Implicit Intent","Error in opening web page.");
        //}
    }


    public void openLocation(View view) {
        String locay = mEdttxt2.getText().toString();
        Uri adressUri = Uri.parse("geo:0,0?q=" + locay);
        Intent intent = new Intent(Intent.ACTION_VIEW, adressUri);
        //if (intent.resolveActivity(getPackageManager())!= null){
        startActivity(intent);
        //}else {
        //  Log.d("ImplicitIntent", "Cannot handle!");
        // }
    }

    public void shareText(View view) {
        String txt = mEdttxt3.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setText(txt)
                .setChooserTitle("Share text with: ")
                .startChooser();
    }
}