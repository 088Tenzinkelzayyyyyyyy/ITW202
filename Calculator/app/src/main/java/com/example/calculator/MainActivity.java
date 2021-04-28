package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mOperandOneEdtTxt;
    private EditText mOperandTwoEdtTxt;
    private TextView mResultTxtView;
    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();
        mOperandOneEdtTxt = findViewById(R.id.editText1);
        mOperandTwoEdtTxt = findViewById(R.id.editText2);
        mResultTxtView = findViewById(R.id.txtv2);
    }
    public void Add(View view){
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.add(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        mResultTxtView.setText(String.valueOf(value));
    }

    public void Sub(View view){
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.sub(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        mResultTxtView.setText(String.valueOf(value));

    }
    public void Mul(View view){
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.mul(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        mResultTxtView.setText(String.valueOf(value));

    }
    public void Div(View view){
        String operandOne = mOperandOneEdtTxt.getText().toString();
        String operandTwo = mOperandTwoEdtTxt.getText().toString();

        double value = mCalculator.div(Double.valueOf(operandOne),Double.valueOf(operandTwo));
        mResultTxtView.setText(String.valueOf(value));

    }

}