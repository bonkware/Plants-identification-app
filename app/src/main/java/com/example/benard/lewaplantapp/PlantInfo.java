package com.example.benard.lewaplantapp;

/**
 * Created by benard on 8/1/17.
 *
 */
       import android.app.TabActivity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.TabHost;
        import android.widget.TabHost.TabSpec;

public class PlantInfo extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plantinfo);

        TabHost tabHost = getTabHost();

        // Tab for Description
        TabSpec desc = tabHost.newTabSpec("Description");
        // setting Title and Icon for the Tab
        desc.setIndicator("Description");
        Intent descIntent = new Intent(this, Description.class);
        desc.setContent(descIntent);

        // Tab for Uses
        TabSpec uses = tabHost.newTabSpec("Uses");
        uses.setIndicator("Uses");
        Intent usesIntent = new Intent(this, Uses.class);
        uses.setContent(usesIntent);

        // Tab for Ecology
        TabSpec ecology = tabHost.newTabSpec("Ecology");
        ecology.setIndicator("Ecology");
        Intent ecologyIntent = new Intent(this, Ecology.class);
        ecology.setContent(ecologyIntent);

        // Adding all TabSpec to TabHost
        tabHost.addTab(desc); // Adding description tab
        tabHost.addTab(uses); // Adding uses tab
        tabHost.addTab(ecology); // Adding Ecology tab
    }
}
