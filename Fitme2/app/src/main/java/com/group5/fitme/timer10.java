package com.group5.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;


import com.group5.fitme.databinding.ActivityMainBinding;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class timer10 extends AppCompatActivity {
    ActivityMainBinding binding;
    private static final long START_TIME_In_MILLS = 60000;

    GifImageView imageView;
    ImageButton next, previous;
    int i=0;
    private int [ ] textureArrayWin ={R.drawable.explosive_lunge, R.drawable.lunge_jump, R.drawable.ab_core};
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_In_MILLS;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_timer10);


        mTextViewCountDown = findViewById(R.id.countdown);
        mButtonStartPause = findViewById(R.id.btnstart_pause);
        mButtonReset = findViewById(R.id.reset);

        imageView = findViewById(R.id.img);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);

        if (i == 0){
            previous.setVisibility(View.GONE);
        }
        if (i == 5) {
            next.setVisibility(View.GONE);
        }

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(textureArrayWin[i]);
                i --;
                if (i == 0) {
                    previous.setVisibility((View.GONE));
                } else {
                    previous.setVisibility(View.VISIBLE);
                }
                if (i == 5) {
                    next.setVisibility(View.GONE);
                } else {
                    previous.setVisibility(View.VISIBLE);
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(textureArrayWin[i]);
                i ++;
                if (i == 0) {
                    previous.setVisibility((View.GONE));
                } else {
                    previous.setVisibility(View.VISIBLE);
                }
                if (i == 5) {
                    next.setVisibility(View.GONE);
                } else {
                    previous.setVisibility(View.VISIBLE);
                }
            }
        });


        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();
    }

    private void initSlider() {
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_In_MILLS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
//    public void start(View view) {
//        Intent intent = new Intent(this, Timer.class);
//        startActivity(intent);
//    }

    public void timeRest(View view) {
        Intent intent = new Intent(this, Timer.class);
        startActivity(intent);
    }
}