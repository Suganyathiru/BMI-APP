package com.example.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android .widget.EditText;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
        EditText height;
        EditText weight;
        TextView result;
        Button calculate;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            height = (EditText) findViewById(R.id.height);
            weight = (EditText) findViewById(R.id.weight);
            result = (TextView) findViewById(R.id.result);
            calculate = (Button) findViewById(R.id.calculate);

            calculate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    calculateBMI();
                }
            });
        }



        public void calculateBMI() {

            String heightStr = height.getText().toString();

            String weightStr = weight.getText().toString();



            if (heightStr != null && !"".equals(heightStr)

                    && weightStr != null  &&  !"".equals(weightStr)) {

                float heightValue = Float.parseFloat(heightStr) / 100;

                float weightValue = Float.parseFloat(weightStr);



                float bmi = weightValue / (heightValue * heightValue);



                displayBMI(bmi);

            }

        }



        private void displayBMI(float bmi) {

            String bmiLabel = "";



            if (Float.compare(bmi, 15f) <= 0) {

                bmiLabel = "very_severely_underweight";

            } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {

                bmiLabel = "severely_underweight";

            } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {

                bmiLabel = "underweight";

            } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {

                bmiLabel = "normal";

            } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {

                bmiLabel = "overweight";

            } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {

                bmiLabel = ".obese_class";

            } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {

                bmiLabel = "obese_class_ii";

            } else {

                bmiLabel = "obese_class_iii";

            }



            bmiLabel = bmi + "\n\n" + bmiLabel;

            result.setText(bmiLabel);

        }

    }
