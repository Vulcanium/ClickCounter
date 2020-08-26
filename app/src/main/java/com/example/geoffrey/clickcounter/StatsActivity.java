package com.example.geoffrey.clickcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        TextView statView = findViewById(R.id.stats_tv);
        String text = getResources().getString(R.string.click_stat);
        statView.setText(String.format(text, getNbClicks()));
    }

    private int getNbClicks() {
        Intent i = getIntent();
        return i.getIntExtra("NB_CLICKS", 0);
    }
}
