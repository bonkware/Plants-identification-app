package com.example.benard.lewaplantapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by benard on 8/14/17.
 *
 */

public class Home extends Activity {
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.identify);
        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
    //More information
    public void popup(View v) {
        Intent intent = new Intent(Home.this, GeneralInfo.class);
        startActivity(intent);
    }
}
