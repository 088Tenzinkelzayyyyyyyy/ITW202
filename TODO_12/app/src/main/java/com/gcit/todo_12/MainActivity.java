package com.gcit.todo_12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView donut,froyo,sandwich;
    private FloatingActionButton fab;
    //private ImageView IDonut,Ifroyo,Isandwich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donut=findViewById(R.id.txtDonut);
        froyo=findViewById(R.id.textfroyo);
        sandwich=findViewById(R.id.textsandwich);
        fab=findViewById(R.id.fab);

    }


    public void Donut(View view) {
        Toast toast = Toast.makeText(this,R.string.order,Toast.LENGTH_LONG);
        toast.show();
    }

    public void Sandwich(View view) {
        Toast toast = Toast.makeText(this,R.string.order2,Toast.LENGTH_LONG);
        toast.show();
    }

    public void Froyo(View view) {
        Toast toast = Toast.makeText(this,R.string.order3,Toast.LENGTH_LONG);
        toast.show();
    }

    public void fab(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        startActivity(intent);

    }
}