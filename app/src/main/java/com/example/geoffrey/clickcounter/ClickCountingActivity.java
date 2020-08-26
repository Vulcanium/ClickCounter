package com.example.geoffrey.clickcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClickCountingActivity extends AppCompatActivity {
    private int clicks = 0;
    private TextView clicksCountTv;
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_counting);

        text = getResources().getString(R.string.nb_clics);

        clicksCountTv = findViewById(R.id.textView);

        findViewById(R.id.incr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incr();
            }
        });

        findViewById(R.id.stat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchStatsActivity();
            }
        });

        updateText();
    }

    private void incr() {
        clicks++;
        updateText();
    }

    private void updateText() {
        clicksCountTv.setText(String.format(text, clicks));
    }

    private void launchStatsActivity() {
        Intent i = new Intent(this, StatsActivity.class);
        i.putExtra("NB_CLICKS", clicks);
        startActivity(i);
    }
}
