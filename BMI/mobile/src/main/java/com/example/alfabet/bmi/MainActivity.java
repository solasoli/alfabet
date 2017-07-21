package com.example.alfabet.bmi;


import android.os.Build;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;






public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButtonListenerMethod();
    }
        public void myButtonListenerMethod() {

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {



                    final EditText heightText = (EditText)
                            findViewById(R.id.heightInput);
                    String heightStr = heightText.getText().toString();
                    double height = Double.parseDouble(heightStr);

                    final EditText weightText = (EditText)
                            findViewById(R.id.weightInput);
                    String weightStr = weightText.getText().toString();
                    double weight = Double.parseDouble(weightStr);

                    double BMI = (weight)/(height*height);
                    android.icu.text.DecimalFormat df = new android.icu.text.DecimalFormat(int);
                    double BMI_trimmed = Double.parseDouble(df.format(BMI));

                    final EditText BMIresult = (EditText)
                            findViewById(R.id.BMI_result);
                    BMIresult.setText(Double.toString(BMI_trimmed));

                    String BMI_cat;

                    if (BMI < 15)
                        BMI_cat = "Very Severly Underweight";

                    if (BMI < 16)
                        BMI_cat = "Severly Underweight";

                    if (BMI < 18.5)
                        BMI_cat = "Underweight";

                    if (BMI < 25)
                        BMI_cat = "Normal";

                    if (BMI < 30)
                        BMI_cat = "Overweight";

                    if (BMI < 35)
                        BMI_cat = "Obese Class 1 - Moderately Obese";



                    final TextView BMICategory = (TextView)
                            findViewById(R.id.BMI_cat);
                    BMICategory.setText(BMI_cat);
                }
            });
        }






    }











