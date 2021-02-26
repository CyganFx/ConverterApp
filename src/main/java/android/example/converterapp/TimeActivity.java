package android.example.converterapp;

import android.os.Bundle;
import android.widget.TextClock;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.TimeZone;

public class TimeActivity extends AppCompatActivity {
    private TextClock astanaClock;
    private TextClock nyClock;
    private TextClock africaClock;
    private TextClock antiguaTextClock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        nyClock = (TextClock) findViewById(R.id.nyTextClock);
        astanaClock = (TextClock) findViewById(R.id.astanaTextClock);
        africaClock = (TextClock) findViewById(R.id.africaTextClock);
        antiguaTextClock = (TextClock) findViewById(R.id.antiguaTextClock);

        astanaClock.setFormat12Hour("hh:mm:ss a");
        nyClock.setTimeZone("America/New_York");
        nyClock.setFormat12Hour("hh:mm:ss a");
        africaClock.setTimeZone("Africa/Lagos");
        africaClock.setFormat12Hour("hh:mm:ss a");
        antiguaTextClock.setTimeZone("America/Antigua");
        antiguaTextClock.setFormat12Hour("hh:mm:ss a");
    }
}


