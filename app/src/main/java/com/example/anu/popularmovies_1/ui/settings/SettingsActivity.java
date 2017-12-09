package com.example.anu.popularmovies_1.ui.settings;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.anu.popularmovies_1.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_settings);
        if (null != getSupportActionBar())
            getSupportActionBar().setTitle(getResources().getString(R.string.settings));
    }
}
