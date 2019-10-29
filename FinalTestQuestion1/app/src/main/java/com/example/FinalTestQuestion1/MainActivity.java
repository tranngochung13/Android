package com.example.FinalTestQuestion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.FinalTestQuestion1.R;

public class MainActivity extends AppCompatActivity {

    EditText edtData1, edtData2, edtResult;
    Button btSum, btMultiple, btAverage;
    Integer number1, number2, sum, multiple, average;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtData1 = findViewById(R.id.edtData1);
        edtData2 = findViewById(R.id.edtData2);
        edtResult = findViewById(R.id.edtResult);
        btSum = findViewById(R.id.buttonSum);
        btAverage = findViewById(R.id.buttonAverage);
        btMultiple = findViewById(R.id.buttonMultiple);

        btSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtResult.setText("");
                number1 =Integer.parseInt(edtData1.getText()+"");
                number2 =Integer.parseInt(edtData2.getText()+"");
                sum = number1+number2;
                edtResult.setText(edtResult.getText().toString()+sum);
            }
        });
        btAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtResult.setText("");
                number1 =Integer.parseInt(edtData1.getText()+"");
                number2 =Integer.parseInt(edtData2.getText()+"");
                average = (number1+number2)/2;
                edtResult.setText(edtResult.getText().toString()+average);
            }
        });
        btMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtResult.setText("");
                number1 =Integer.parseInt(edtData1.getText()+"");
                number2 =Integer.parseInt(edtData2.getText()+"");
                multiple = number1*number2;
                edtResult.setText(edtResult.getText().toString()+multiple);
            }
        });
    }
}
