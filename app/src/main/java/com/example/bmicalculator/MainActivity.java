package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.calc_result);
        TextView scale = findViewById(R.id.scale);
        EditText feet = findViewById(R.id.feet);
        EditText weight = findViewById(R.id.weight);
        AppCompatButton calc_btn = findViewById(R.id.calc_btn);

//        if (feet.getText().toString().isEmpty() || weight.getText().toString().isEmpty()) {
//            calc_btn.setEnabled(false);
//        } else {
//            calc_btn.setEnabled(true);
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        calc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int wei = Integer.parseInt(weight.getText().toString());
                float heift = Float.parseFloat(feet.getText().toString());
                float heiin = Float.parseFloat(feet.getText().toString());

                int totalIn = (int) (heift * 12 + heiin);
                float totalCm = totalIn * 2.54f;
                float totalM = totalCm / 100;
                float bmi = wei / (totalM * totalM);

                scale.setText(String.format("%.2f", bmi));
//                textView.setText(String.format("%.2f", bmi));

                if (bmi < 18.5) {
                    textView.setText("Underweight");
                } else if (bmi >= 18.5 && bmi < 25) {
                    textView.setText("Normal");
                } else if (bmi >= 25 && bmi < 30) {
                    textView.setText("Overweight");
                } else {
                    textView.setText("Obese");
                }
            }
        });
    }
}