package android.example.converterapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button tempButton;
    private Button timeButton;
    private Button currencyButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tempButton = (Button) findViewById(R.id.tempButton);
        timeButton = (Button) findViewById(R.id.timeButton);
        currencyButton = (Button) findViewById(R.id.currencyButton);

        timeButton.setOnClickListener(view -> {
            Intent tempIntent = new Intent(getApplicationContext(), TimeActivity.class);
            startActivity(tempIntent);
        });

        tempButton.setOnClickListener(view -> {
            Intent tempIntent = new Intent(getApplicationContext(), TemperatureConverterActivity.class);
            startActivity(tempIntent);
        });

        currencyButton.setOnClickListener(view -> {
            Intent tempIntent = new Intent(getApplicationContext(), CurrencyConverterActivity.class);
            startActivity(tempIntent);
        });
    }
}