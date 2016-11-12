package com.example.charl.yhackapp_financialmanagement;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.util.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void inputAccountNumber(View view) {
        Intent intent = new Intent(this, BankAPI.class);
        EditText accountNumber = (EditText) findViewById(R.id.edit_message);

    }
}
