


package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Weight;
    private EditText Height;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Weight = findViewById(R.id.Weight);
        Height = findViewById(R.id.Height);
        Result = findViewById(R.id.Result);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

    }

    private void calculateBMI() {
        double weight = Double.parseDouble(Weight.getText().toString());
        double height = Double.parseDouble(Height.getText().toString());
        double bmi = weight / (height * height);

        Result.setText("BMI: " + bmi);
    }

}
