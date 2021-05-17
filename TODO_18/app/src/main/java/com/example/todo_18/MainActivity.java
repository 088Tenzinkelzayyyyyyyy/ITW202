package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private ArrayList<Sport>mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview = (RecyclerView)findViewById(R.id.recyclerView);

        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        mSportsData = new ArrayList<>();

        mAdapter = new SportsAdapter(this,mSportsData);
        mRecyclerview.setAdapter(mAdapter);

        initializeData();



//        // Initialize the views.
//        TextView sportsTitle = findViewById(R.id.title);
//        ImageView sportsImage = findViewById(R.id.sportsImage);
//
//        // Set the text from the Intent extra.
//        sportsTitle.setText(getIntent().getStringExtra("title"));
//
//        // Load the image using the Glide library and the Intent extra.
//        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
//                .into(sportsImage);
    }

    private void initializeData() {
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsList = getResources().getStringArray(R.array.Sports_title);
        String[] sportsInfo = getResources().getStringArray(R.array.Sports_info);

        mSportsData.clear();

        for (int i = 0; i<sportsList.length;i++){
            mSportsData.add(new Sport(sportsList[i],sportsInfo[i],sportsImageResources.getResourceId(i,0)));
        }
        mAdapter.notifyDataSetChanged();
    }
}