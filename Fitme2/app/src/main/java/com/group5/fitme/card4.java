package com.group5.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class card4 extends AppCompatActivity implements View.OnClickListener {

    public TextView exer1, exer2, exer3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card4);

        exer1 = (TextView) findViewById (R.id.exer1);
        exer2 = (TextView) findViewById (R.id.exer2);
        exer3 = (TextView) findViewById (R.id.exer3);


        exer1.setOnClickListener(this);
        exer2.setOnClickListener(this);
        exer3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.exer1:
                i = new Intent(this,btn10.class);
                startActivity(i);
                break;
            case R.id.exer2:
                i = new Intent(this,btn11.class);
                startActivity(i);
                break;
            case R.id.exer3:
                i = new Intent(this,btn12.class);
                startActivity(i);
                break;
        }

    }
}