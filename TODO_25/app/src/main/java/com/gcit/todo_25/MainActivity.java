package com.gcit.todo_25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText FName, LName, Marks, Id;
    // Button add, view, delete, update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);

        myDb = new DatabaseHelper(this);
        FName = findViewById(R.id.fname);
        LName = findViewById(R.id.lname);
        Marks = findViewById(R.id.marks);
        Id = findViewById(R.id.idNum);

    }

    public void addData(View view) {

        boolean isInserted = myDb.insertData(Id.getText().toString(),
                FName.getText().toString(),
                LName.getText().toString(), Marks.getText().toString());
        if (isInserted == true)
            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
    }

    public void ViewData(View view) {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            //show message
            showMessage("Error", "Nothing to insert");
            return;
        }
        //classes that work with strings
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Student ID : " + res.getString(0) + "\n");
            buffer.append("First Name : " + res.getString(1) + "\n");
            buffer.append("Last Name : " + res.getString(2) + "\n");
            buffer.append("ITW202 Marks : " + res.getString(3) + "\n\n");


        }
        //show all data
        showMessage("List of students", buffer.toString());
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void UpdateData(View view) {
        boolean isUpdate = myDb.updateData(Id.getText().toString(),
                FName.getText().toString(),
                LName.getText().toString(),
                Marks.getText().toString());

        if (isUpdate == true)
            Toast.makeText(this, "Data Updated", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Data not Updated", Toast.LENGTH_SHORT).show();
    }

    public void DeleteData(View view) {
        Integer deleteRows = myDb.deleteData(Id.getText().toString());
        if (deleteRows > 0)
            Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Data not deleted", Toast.LENGTH_SHORT).show();


    }
}