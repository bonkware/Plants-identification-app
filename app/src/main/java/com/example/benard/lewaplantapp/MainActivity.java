package com.example.benard.lewaplantapp;


import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //declare
    private ListView listView;
    private ColorAdapter color;
    private List<Cglobal> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.colors);

        this.listView = (ListView) findViewById(R.id.listView);
        //Accessing database access class
        DbHandler db = DbHandler.getInstance(this);
        db.open();
        Cursor cursor = db.getColors();
        if (cursor.moveToFirst()) {
            do {
                Cglobal color = new Cglobal();
                color.setColor((cursor.getString(1)));
                colors.add(color);
            } while (cursor.moveToNext());
        }
        color = new ColorAdapter(this, colors);
        listView.setAdapter(color);
        db.close();

        // added onclick listener for next activity and its result
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, FlowerColors.class);
                Cglobal gv = Cglobal.getInstance();
                switch (position)
                {
                    case 0: // first color
                        gv.setId(1);
                        break;
                    case 1:
                        gv.setId(2);
                        break;
                    case 2:
                        gv.setId(3);
                        break;
                    case 3:
                        gv.setId(4);
                        break;
                    case 4:
                        gv.setId(5);
                        break;
                    case 5:
                        gv.setId(6);
                        break;
                    case 6:
                        gv.setId(7);
                        break;
                    case 7:
                        gv.setId(8);
                        break;
                    case 8:
                        gv.setId(9);
                        break;
                }
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
            }
        });

    }
}