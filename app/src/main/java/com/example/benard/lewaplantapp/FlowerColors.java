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

public class FlowerColors extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.flower_colors);
        Cglobal gv = Cglobal.getInstance();

          gv.setflower_color_id(0);

        Cursor cursor;
        DbHandler databaseAccess = DbHandler.getInstance(this);
        databaseAccess.open();
        cursor = databaseAccess.getFlower_colors();
       /* if (cursor.moveToFirst()) {
            do {
                Cglobal c = new Cglobal();
                c.setColor((cursor.getString(1)));
            } while (cursor.moveToNext());
        }*/
        ListView color = (ListView) findViewById(R.id.flower_color);
        FlowerColorAdapter uses= new FlowerColorAdapter(this,cursor);
        color.setAdapter(uses);
        color.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView flower_color_id = (TextView) view.findViewById(R.id.fid);

                TextView flower_color = (TextView) view.findViewById(R.id.fcolor);

                int fid= Integer.parseInt(flower_color_id.getText().toString());

                Cglobal gv = Cglobal.getInstance();
                gv.setflower_color_id(fid);
                gv.setflower_color(flower_color.getText().toString());

                Intent intent = new Intent(getApplication(),VegetativeType.class);
                intent.putExtra("flower_color",fid);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);

            }

        });
    }
}


