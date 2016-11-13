package com.example.charl.yhackapp_financialmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FinancialInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_info);

        Intent intent = getIntent();
        int currentAssets = intent.getIntExtra(MainActivity.EXTRA_MESSAGE,MainActivity.money);
        int time = getEstimatedTime(currentAssets);
    }

    public int getEstimatedTime(int money) {

    }




}
