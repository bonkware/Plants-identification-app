package com.example.benard.lewaplantapp;

/**
 * Created by benard on 8/1/17.
 */
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Uses extends Activity {
    private TextView name;
    TableLayout tableLayout2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uses);
        tableLayout2 = (TableLayout) findViewById(R.id.tableLayout2);

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
            TextView[] common_name = new TextView[textViewCount];
            TextView[] uses = new TextView[textViewCount];
            if (cursor.moveToFirst()) {
                for (int i = 0; i < textViewCount; i++) {
                    common_name[i] = new TextView(this);
                    common_name[i].setText(cursor.getString(2));
                    uses[i] = new TextView(this);
                    uses[i].setText(cursor.getString(3));
                    TableRow desc = new TableRow(this);
                    desc.setBackgroundResource(R.drawable.row_border);

                    //set table and text properties programmatically
                    common_name[i].setPadding(2, 0, 0, 0);
                    uses[i].setPadding(2, 0, 0, 0);
                    common_name[i].setGravity(Gravity.CENTER);
                    uses[i].setGravity(Gravity.CENTER);

                    desc.addView(common_name[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    desc.addView(uses[i], new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f));
                    TL.addView(desc);
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

