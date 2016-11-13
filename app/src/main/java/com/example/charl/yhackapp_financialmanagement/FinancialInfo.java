package com.example.charl.yhackapp_financialmanagement;

import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;

public class FinancialInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_info);

        Intent intent = getIntent();
        int yourMoney = (intent.getIntExtra(MainActivity.EXTRA_MESSAGE1, 0));
        int collegeExpenses = (intent.getIntExtra(MainActivity.EXTRA_MESSAGE2,0));
        int income = (intent.getIntExtra(MainActivity.EXTRA_MESSAGE4,0));
        double daysLeft = estimateTimeLeft(yourMoney,collegeExpenses, income);
        if(income/14.0>=((collegeExpenses)/7.0)) {
            String daysleft = String.format("%.2f",daysLeft);
            String message = "Your assets will be approximately $"+daysleft+" after a month. Keep it up!";
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(message);
            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_financial_info);
            layout.addView(textView);
        }
        else {
            daysLeft = (int) daysLeft;
            String message = "Your current situation will last approximately "+daysLeft+" days.";
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(message);
            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_financial_info);
            layout.addView(textView);
        }
    }

    public static double estimateTimeLeft(int assets, int cexpenses, int income) {
        if(income/14.0>=(cexpenses)/7.0) {
            return assets + (income/14.0)*30.0 - ((cexpenses)/7.0)*30.0;
        }
        double initial = assets/(cexpenses/7.0);
        double difference=1;
        while(difference>=1) {
            double previousAssets = assets;
            double incomeMade = initial * (income / 14.0);
            assets += incomeMade;
            difference = assets-previousAssets;
            initial = difference/((cexpenses)/7.0);
        }
        return assets/((cexpenses)/7.0);
    }

}





