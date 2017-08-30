package com.example.benard.lewaplantapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
/**
 * Created by benard on 7/31/17.
 */

public class MainActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.colors);
        Cglobal gv = Cglobal.getInstance();

        gv.setId(0);

        Cursor cursor;
        DbHandler databaseAccess = DbHandler.getInstance(this);
        databaseAccess.open();
        cursor = databaseAccess.getColors();
       /* if (cursor.moveToFirst()) {
            do {
                Cglobal c = new Cglobal();
                c.setColor((cursor.getString(1)));
            } while (cursor.moveToNext());
        }*/
        ListView color = (ListView) findViewById(R.id.color);
        ColorAdapter uses= new ColorAdapter(this,cursor);
        color.setAdapter(uses);
        color.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView flower_color_id = (TextView) view.findViewById(R.id.cid);

                TextView color = (TextView) view.findViewById(R.id.color);

                int cid= Integer.parseInt(flower_color_id.getText().toString());

                Cglobal gv = Cglobal.getInstance();
                gv.setflower_color_id(cid);
                gv.setColor(color.getText().toString());

                Intent intent = new Intent(getApplication(),VegetativeType.class);
                intent.putExtra("color",cid);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);

            }

        });
    }
}


