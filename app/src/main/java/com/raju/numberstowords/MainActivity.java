package com.raju.numberstowords;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.et_number);
        result = findViewById(R.id.tvResult);
    }

    public void convertToWords(View view) {
        String value = number.getText().toString().trim();
        if (value.isEmpty()) {
            number.setError("Please enter a number!!!");
        } else {
            result.setText(numbersToWords(Integer.parseInt(value)));
            result.setVisibility(View.VISIBLE);
        }
    }

    private String numbersToWords(int num) {
        String[] oneToNineteen = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
                " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};

        String[] tenToNinety = {"", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"};

        String word = "";

        if (num == 0) {
            word = "Zero";
        } else if (num < 20) {
            word = oneToNineteen[num];
        } else if (num >= 20 && num < 100) {
            word = tenToNinety[num / 10] + oneToNineteen[num % 10];
        } else {
            int rem = num % 100;
            word = oneToNineteen[num / 100] + " Hundred" + (rem > 0 && rem < 20 ? " and" + oneToNineteen[rem] : " and" + tenToNinety[rem / 10] + oneToNineteen[rem % 10]);
        }
        return word;
    }
}
