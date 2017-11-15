package com.example.benard.lewaplantapp;

/**
 * Created by benard on 8/1/17.
 *
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ZoomControls;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Description extends Activity {
    private TextView name;
    private TextView imagename;
    TableLayout tableLayout2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);


        tableLayout2 = (TableLayout) findViewById(R.id.tableLayout2);

        Cglobal gt = Cglobal.getInstance();
        String plantName = "Plant Name: " + gt.getscintific_name();
        name = (TextView) findViewById(R.id.name);
        name.setText(plantName);
        String imageplantname = "Plant image of " + gt.getscintific_name();
        imagename = (TextView) findViewById(R.id.imagename);
        imagename.setText(imageplantname);

        ImageView setImage = (ImageView) findViewById(R.id.img);

        TableLayout TL = (TableLayout) findViewById(R.id.tableLayout2);
        DbHandler databaseAccess = DbHandler.getInstance(this);
        databaseAccess.open();
        Cursor cursor = databaseAccess.getplantInfo();
        if (cursor.getCount() > 0) {
            int textViewCount = cursor.getCount();
            TextView[] family = new TextView[textViewCount];
            TextView[] description = new TextView[textViewCount];
            if (cursor.moveToFirst()) {
                for (int i = 0; i < textViewCount; i++) {
                    //get the plant image of the species
                    String imgName = cursor.getString(cursor.getColumnIndex("image_name"));
                    int image = getResources().getIdentifier(imgName, "drawable", getPackageName());
                    setImage.setImageResource(image);
                    setImage.setAdjustViewBounds(true);

                    //other information
                    family[i] = new TextView(this);
                    family[i].setText(cursor.getString(0));
                    description[i] = new TextView(this);
                    description[i].setText(cursor.getString(1));
                    TableRow desc = new TableRow(this);
                    desc.setBackgroundResource(R.drawable.row_border);

                    //set table and text properties programmatically
                    family[i].setPadding(2, 0, 0, 0);
                    description[i].setPadding(2, 0, 0, 0);
                    //family[i].setGravity(Gravity.CENTER);
                    //description[i].setGravity(Gravity.CENTER);

                    desc.addView(family[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    desc.addView(description[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    TL.addView(desc);
                    cursor.moveToNext();
                }//end for
            }//end if cursor check
        }
        databaseAccess.close();
    }

    public void back(View view) {
        Intent intent = new Intent(getApplication(), PlantName.class);
        startActivity(intent);
    }
}
