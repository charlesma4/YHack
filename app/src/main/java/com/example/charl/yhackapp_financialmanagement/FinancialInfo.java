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
        int otherExpenses = (intent.getIntExtra(MainActivity.EXTRA_MESSAGE3,0));
        int income = (intent.getIntExtra(MainActivity.EXTRA_MESSAGE4,0));
        double daysLeft = estimateTimeLeft(yourMoney,collegeExpenses,otherExpenses, income);
        if(income/14>((collegeExpenses+otherExpenses)/7)) {
            String message = "Your assets will increase to "+daysLeft+" after a month. Keep it up!";
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(message);
            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_financial_info);
            layout.addView(textView);
        }
        else {
            String message = "Your current situation will last "+daysLeft+" days.";
            TextView textView = new TextView(this);
            textView.setTextSize(40);
            textView.setText(message);
            ViewGroup layout = (ViewGroup) findViewById(R.id.activity_financial_info);
            layout.addView(textView);
        }
    }

    public static double estimateTimeLeft(int assets, int cexpenses, int oexpenses, int income) {
        if(income/14>(cexpenses+oexpenses)/7) {
            return assets + (income/14)*30 - ((cexpenses+oexpenses)/7)*30;
        }
        double initial = assets/((cexpenses+oexpenses)/7);
        double difference=11;
        while(difference>10) {
            double previousAssets = assets;
            double incomeMade = initial * (income / 14);
            assets += incomeMade;
            difference = assets-previousAssets;
            initial = difference;
        }
        return assets/((cexpenses+oexpenses)/7);
    }

}





