package com.example.benard.lewaplantapp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by benard on 7/31/17.
 */

public class PlantName extends AppCompatActivity {
    private TextView pname;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.plant_name);
        Cglobal gv = Cglobal.getInstance();

        gv.setinfo_id(0);
        String colorName = "You selected "+gv.getColor()+ " and " + gv.getvegetative_type();
        pname = (TextView) findViewById(R.id.pname);
        pname.setText(colorName);

        Cursor cursor;
        DbHandler databaseAccess = DbHandler.getInstance(this);
        databaseAccess.open();
        cursor = databaseAccess.getInfo();
        ListView vtype = (ListView) findViewById(R.id.sinfo);
        PlantInfoAdapter sp_info= new PlantInfoAdapter(this,cursor);
        vtype.setAdapter(sp_info);
        vtype.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView info_id = (TextView) view.findViewById(R.id.sid);
                TextView scientic_name = (TextView) view.findViewById(R.id.sname);

                int sid= Integer.parseInt(info_id.getText().toString());

                Cglobal gv = Cglobal.getInstance();
                gv.setinfo_id(sid);
                gv.setscientific_name(scientic_name.getText().toString());

                 Intent intent = new Intent(getApplication(),PlantInfo.class);
                 intent.putExtra("scientific_name",sid);
                  startActivity(intent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);

            }

        });
    }

}

