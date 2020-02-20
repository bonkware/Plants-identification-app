package com.example.benard.lewaplantapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by benard on 11/14/17.
 */

public class GeneralInfo extends AppCompatActivity {
    private TextView url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generalinfo);

        String link = "http://www.lewa.org//";
        url = (TextView) findViewById(R.id.url);
        url.setText(link);
    }
}
