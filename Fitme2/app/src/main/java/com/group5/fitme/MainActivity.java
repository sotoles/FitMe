package com.group5.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView titlepage, subtitlepage, text;
    Button btnlogin, btnregister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnregister = (Button) findViewById(R.id.btnregister);
        text = (TextView) findViewById(R.id.text);


    }
    public void start(View view) {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
    public void register(View view) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }
}