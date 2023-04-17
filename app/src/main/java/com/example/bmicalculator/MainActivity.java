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

        Button btnReset = findViewById(R.id.btnReset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(Weight.getText().toString());
            double height = Double.parseDouble(Height.getText().toString());
            double height_in_meter=height/100;
            double bmi = weight / (height_in_meter * height_in_meter);

            //Categories Added
            String category = "";

            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi >= 18.5 && bmi < 25) {
                category = "Normal";
            } else if (bmi >= 25 && bmi < 30) {
                category = "Overweight";
            } else {
                category = "Obesity";
            }

            Result.setText("BMI: " + bmi + "\nCategory: " + category);
            TextView errorTextView = findViewById(R.id.Error);
            errorTextView.setVisibility(View.GONE);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            TextView errorTextView = findViewById(R.id.Error);
            errorTextView.setVisibility(View.VISIBLE);
            errorTextView.setText("Error: Invalid input. Please enter a number.");
        }
    }



    private void resetFields() {
        Weight.setText("");
        Height.setText("");
        Result.setText("");
        TextView errorTextView = findViewById(R.id.Error);
        errorTextView.setVisibility(View.GONE);
    }
}