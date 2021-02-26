package android.example.converterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CurrencyConverterActivity extends AppCompatActivity {
    private EditText transferCurrency;
    private EditText userCurrency;
    private Button convertButton;
    private TextView resultText;
    private EditText moneyAmount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        transferCurrency = (EditText) findViewById(R.id.wantedCurrency);
        userCurrency = (EditText) findViewById(R.id.userCurrency);
        convertButton = (Button) findViewById(R.id.convertButton);
        resultText = (TextView) findViewById(R.id.resultText);
        moneyAmount = (EditText) findViewById(R.id.moneyAmount);


        convertButton.setOnClickListener(view -> {
            String currency = userCurrency.getText().toString().trim().toUpperCase();
            String wantedCurrency = transferCurrency.getText().toString().trim().toUpperCase();
            if ((currency.equals("KZT") || currency.equals("USD") || currency.equals("EUR")) &&
                    (wantedCurrency.equals("KZT") || wantedCurrency.equals("USD") || wantedCurrency.equals("EUR"))) {
                try {
                    double money = Double.parseDouble(moneyAmount.getText().toString().trim());
                    double result = converter(money, currency, wantedCurrency);
                    resultText.setText(Double.toString(result));
                } catch (NumberFormatException e) {
                    Toast.makeText(CurrencyConverterActivity.this, "Check your 'amount' field, please!", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(CurrencyConverterActivity.this, "Supported currencies: KZT, USD, EUR", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double converter(double money, String userCurrency, String wantedCurrency) {
        if (wantedCurrency.equals("KZT")) {
            if (userCurrency.equals("EUR")) {
                return money * 507;
            }
            if (userCurrency.equals("USD")) {
                return money * 417;
            }
        }

        if (wantedCurrency.equals("EUR")) {
            if (userCurrency.equals("KZT")) {
                return (money * 0.0019);
            }
            if (userCurrency.equals("USD")) {
                return (money * 0.82);
            }
        }

        if (wantedCurrency.equals("USD")) {
            if (userCurrency.equals("KZT")) {
                return (money * 0.0022);
            }
            if (userCurrency.equals("EUR")) {
                return (money * 1.21);
            }
        }
        return money;
    }
}
