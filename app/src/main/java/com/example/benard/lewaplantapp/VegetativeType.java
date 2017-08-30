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

public class VegetativeType extends AppCompatActivity {
    private TextView color;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.vegetative_type);
        Cglobal gv = Cglobal.getInstance();

        gv.setvegetative_type_id(0);
        //selected flower color
        String colorName = "You selected " + gv.getColor() +" flower color";
        color = (TextView) findViewById(R.id.color);
        color.setText(colorName);

        Cursor cursor;
        DbHandler databaseAccess = DbHandler.getInstance(this);
        databaseAccess.open();
        cursor = databaseAccess.getvtype();
        ListView vtype = (ListView) findViewById(R.id.vegType);
        VegetativeTypeAdapter veg_type= new VegetativeTypeAdapter(this,cursor);
        vtype.setAdapter(veg_type);
        vtype.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView vegetative_type_id = (TextView) view.findViewById(R.id.vid);

                TextView vegetative_type = (TextView) view.findViewById(R.id.vtype);

                int vid= Integer.parseInt(vegetative_type_id.getText().toString());

                Cglobal gv = Cglobal.getInstance();
                gv.setvegetative_type_id(vid);
                gv.setvegetative_type(vegetative_type.getText().toString());

                Intent intent = new Intent(getApplication(),PlantName.class);
                intent.putExtra("vegetative_type",vid);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

            }

        });
    }

}
