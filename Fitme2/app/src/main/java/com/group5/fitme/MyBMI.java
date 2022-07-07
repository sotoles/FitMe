package com.group5.fitme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MyBMI extends AppCompatActivity {

    Button btn;
    EditText height, weight;
    TextView result;
    String calculation, BMIresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bmi);

        btn = findViewById(R.id.btn);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
    }

    public void calculateBMI (View view) {
        String S1 = weight.getText().toString();
        String S2 = height.getText().toString();

        float weightValue = Float.parseFloat(S1);
        float heightValue = Float.parseFloat(S2) / 100;
        float bmi = weightValue / (heightValue * heightValue);

        if (bmi < 16) {
            BMIresult = "Severely Under Weight \n You need to do Cardiovascular Endurance \n (Beginner)";
        } else if (bmi < 18.5) {
            BMIresult = "Under Weight \n You need to do Cardiovascular Endurance \n (Moderate)";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            BMIresult = "Normal Weight \n You need to do Flexibility \n (Advance)";
        } else if (bmi >= 25 && bmi <= 29.9) {
            BMIresult = "Overweight \n You need to do Body Composition \n (Moderate)";
        } else {
            BMIresult = "Obese \n You need to do Body Composition \n (Advance)";
        }

        calculation = "\n" + bmi + "\n" + BMIresult;
        result.setText(calculation);
    }
}
