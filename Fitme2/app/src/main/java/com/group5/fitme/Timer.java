package com.group5.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.media.audiofx.AutomaticGainControl;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Timer extends AppCompatActivity {
    //Initialize variable
    TextView textView ;
    Button next ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //Assign variable
        textView = findViewById(R.id.text_view);


        //Initialize timer duration
        long duration = TimeUnit.MINUTES.toMillis(3);

        //Initialize countdown timer
        new CountDownTimer(duration, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                //When tick
                //Covert millisecond to minute and second
                String sDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                        ,TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                        ,TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)-
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                //Set converted string on the text view
                textView.setText(sDuration);

            }

            @Override
            public void onFinish() {
                //When finish
                //Hide text view
                textView.setVisibility(View.VISIBLE);
                //Display toast
                Toast.makeText(getApplicationContext()
                        ,"Countdown timer has stop",Toast.LENGTH_LONG).show();

            }
        }.start();
    }
}