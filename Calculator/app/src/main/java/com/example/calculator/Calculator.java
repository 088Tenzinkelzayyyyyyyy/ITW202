package com.example.calculator;

public class Calculator {
    public enum Oprerator {ADD, SUB, MUL, DIV}

    public double add(double operandOne, double operandTwo){
        return operandOne + operandTwo;
    }
    public double sub(double operandOne, double operandTwo){
        return operandOne - operandTwo;
    }
    public double mul(double operandOne, double operandTwo){
        return operandOne * operandTwo;
    }
    public double div(double operandOne, double operandTwo){
        return operandOne / operandTwo;
    }
}
