package android.example.converterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureConverterActivity extends AppCompatActivity {
    private TextView resultText;
    private EditText wantedTemperature;
    private EditText userTemperature;
    private EditText temperatureAmount;
    private Button resultButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);


        resultText = (TextView) findViewById(R.id.tempResultText);
        wantedTemperature = (EditText) findViewById(R.id.wantedTemperature);
        userTemperature = (EditText) findViewById(R.id.userTemperature);
        temperatureAmount = (EditText) findViewById(R.id.temperatureAmount);
        resultButton = (Button) findViewById(R.id.tempConvertButton);


        resultButton.setOnClickListener(view -> {
            String temp = userTemperature.getText().toString().trim().toLowerCase();
            String wantedTemp = wantedTemperature.getText().toString().trim().toLowerCase();
            if ((temp.equals("c") || temp.equals("f")) &&
                    (wantedTemp.equals("c") || wantedTemp.equals("f"))) {
                try {
                    double userTemp = Double.parseDouble(temperatureAmount.getText().toString().trim());
                    double result = converter(userTemp, temp, wantedTemp);
                    resultText.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(TemperatureConverterActivity.this, "Check your 'temperature' field, please!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(TemperatureConverterActivity.this, "Supported temperatures: C, F", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double converter(double temperature, String userTemp, String wantedTemp) {
        if (wantedTemp.equals("c")) {
            if (userTemp.equals("f")) {
                return (temperature - 32) * 5 / 9;
            }
        }

        if (wantedTemp.equals("f")) {
            if (userTemp.equals("c")) {
                return (temperature * 9 / 5) + 32;
            }
        }
        return temperature;
    }
}
