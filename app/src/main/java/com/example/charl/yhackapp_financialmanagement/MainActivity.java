package com.example.charl.yhackapp_financialmanagement;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.*;
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.YHack.MESSAGE";
    public static int money;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void sendAssets(View view) {
        Intent intent = new Intent(this, FinancialInfo.class);
        EditText input = (EditText) findViewById(R.id.editAssets);
        int totalMoney = Integer.parseInt(input.getText().toString());
        money=totalMoney;
        intent.putExtra(EXTRA_MESSAGE,totalMoney);
        startActivity(intent);
    }
    public void sendFoodExpenses(View view) {

    }
    public void sendGeneralCollegeExpenses(View view) {

    }
    public void sendOtherExpenses(View view) {

    }
}
