package com.example.converttemp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText temp_in_C;
    private EditText temp_in_F;
    private TextView resultView;
    private TextView textViewResultFahrenheit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp_in_C = findViewById(R.id.temp_in_C);
        temp_in_F = findViewById(R.id.temp_in_F);
        resultView = findViewById(R.id.resultView);
     //   textViewResultFahrenheit = findViewById(R.id.textViewResultFahrenheit);

        Button convert = findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String celsiusText = temp_in_C.getText().toString().trim();
        if (!celsiusText.isEmpty()) {
            double celsius = Double.parseDouble(celsiusText);
            double fahrenheit =(celsius * 9 / 5) + 32;
            resultView.setText("Value in F is : " + String.valueOf(fahrenheit));
        }

        String fahrenheitText = temp_in_F.getText().toString().trim();
        if (!fahrenheitText.isEmpty()) {
            double fahrenheit = Double.parseDouble(fahrenheitText);
            double celsius = (fahrenheit - 32) * 5 / 9;
            celsius = (double)Math.round(celsius*100)/100;
            resultView.setText("Value in C is : "+String.valueOf(celsius));
            Toast.makeText(this, "Clear both values to check again", Toast.LENGTH_SHORT).show();
        }
    }
}
