package com.example.benard.lewaplantapp;

/**
 * Created by benard on 8/1/17.
 *
 */
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Ecology extends Activity {
    private TextView name;
    TableLayout tableLayout2;
    TableLayout tableLayout3;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ecology);
        tableLayout2 = (TableLayout) findViewById(R.id.tableLayout2);
        tableLayout3 = (TableLayout) findViewById(R.id.tableLayout3);

        Cglobal gt = Cglobal.getInstance();
        String plantName = "Plant Name: " + gt.getscintific_name();
        name = (TextView) findViewById(R.id.name);
        name.setText(plantName);

        TableLayout TL = (TableLayout) findViewById(R.id.tableLayout2);
        DbHandler databaseAccess = DbHandler.getInstance(this);
        databaseAccess.open();
        Cursor cursor = databaseAccess.getplantInfo();
        if (cursor.getCount() > 0) {
            int textViewCount = cursor.getCount();
            TextView[] ecology = new TextView[textViewCount];
            TextView[] vtype = new TextView[textViewCount];
            if (cursor.moveToFirst()) {
                for (int i = 0; i < textViewCount; i++) {
                    ecology[i] = new TextView(this);
                    ecology[i].setText(cursor.getString(4));
                    vtype[i] = new TextView(this);
                    vtype[i].setText(cursor.getString(5));
                    TableRow desc = new TableRow(this);
                    desc.setBackgroundResource(R.drawable.row_border);

                    //set table and text properties programmatically
                    ecology[i].setPadding(2, 0, 0, 0);
                    vtype[i].setPadding(2, 0, 0, 0);

                    desc.addView(ecology[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    desc.addView(vtype[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    TL.addView(desc);
                    cursor.moveToNext();
                }//end for
            }//end if cursor check
        }
        databaseAccess.close();
        //for distribution and abundance information
        TableLayout TL2 = (TableLayout) findViewById(R.id.tableLayout3);
        if (cursor.getCount() > 0) {
            int textViewCount = cursor.getCount();
            TextView[] distr = new TextView[textViewCount];
            TextView[] abundance = new TextView[textViewCount];
            if (cursor.moveToFirst()) {
                for (int i = 0; i < textViewCount; i++) {
                    distr[i] = new TextView(this);
                    distr[i].setText(cursor.getString(6));
                    abundance[i] = new TextView(this);
                    abundance[i].setText(cursor.getString(7));
                    TableRow desc = new TableRow(this);
                    desc.setBackgroundResource(R.drawable.row_border);

                    //set table and text properties programmatically
                    distr[i].setPadding(2, 0, 0, 0);
                    abundance[i].setPadding(2, 0, 0, 0);
                    distr[i].setGravity(Gravity.CENTER);
                    abundance[i].setGravity(Gravity.CENTER);

                    desc.addView(distr[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    desc.addView(abundance[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    TL2.addView(desc);
                    cursor.moveToNext();
                }//end for
            }//end if cursor check
        }
        databaseAccess.close();
    }
    public void back(View view){
        Intent intent = new Intent(getApplication(),PlantName.class);
        startActivity(intent);
    }
}

