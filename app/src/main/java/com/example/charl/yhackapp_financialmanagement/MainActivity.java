package com.example.charl.yhackapp_financialmanagement;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE1 = "com.example.YHack.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.YHack.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.YHack.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.YHack.MESSAGE4";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendFinancialInfo(View view) {
        Intent intent = new Intent(MainActivity.this, FinancialInfo.class);

        EditText input1 = (EditText) findViewById(R.id.editAssets);
        EditText input2 = (EditText) findViewById(R.id.editCollegeExpenses);
        EditText input3 = (EditText) findViewById(R.id.editOtherExpenses);
        EditText input4 = (EditText) findViewById(R.id.editIncome);
        int yourMoney = Integer.parseInt(input1.getText().toString());
        int collegeExpenses = Integer.parseInt(input2.getText().toString());
        int otherExpenses = Integer.parseInt(input3.getText().toString());
        int income = Integer.parseInt(input4.getText().toString());
        intent.putExtra(EXTRA_MESSAGE1, yourMoney);
        intent.putExtra(EXTRA_MESSAGE2, collegeExpenses);
        intent.putExtra(EXTRA_MESSAGE3, otherExpenses);
        intent.putExtra(EXTRA_MESSAGE4, income);
        startActivity(intent);
    }

}
