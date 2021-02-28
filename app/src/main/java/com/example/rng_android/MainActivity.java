package com.example.rng_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText et_min, et_max;
    private TextView output;
    private int min, max, rand;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_min = findViewById(R.id.txtMin);
        et_max = findViewById(R.id.txtMax);
        output = findViewById(R.id.txtOutput);
    }

    public void onClick(View view) {

        String minStr = et_min.getText().toString();
        String maxStr = et_max.getText().toString();

        if (!minStr.isEmpty() && !maxStr.isEmpty()) {
            min = Integer.valueOf(minStr);
            max = Integer.valueOf(maxStr);

            if ((min > max) || (min == max) || (min == 0 || max == 0)) {
                msg = "Insert a valid interval";
            } else {
                rand = generateInteger(min, max);
                msg = "Number:\n\n" + String.valueOf(rand);
            }

            if (!msg.isEmpty()) {
                output.setText(msg);
            }
        }

    }

    private int generateInteger(int min, int max) {
        return new Random().
                nextInt(max - min + 1) + min;
    }

}