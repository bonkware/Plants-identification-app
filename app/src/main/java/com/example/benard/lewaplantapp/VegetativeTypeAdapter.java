package com.example.benard.lewaplantapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


/**
 * Created by benard on 7/31/17.
 */

public class VegetativeTypeAdapter extends CursorAdapter {

    public  VegetativeTypeAdapter(Context context, Cursor cursor){

        super(context, cursor);

    }
    @Override

    public View newView(Context context, Cursor cursor, ViewGroup parent) {

        return LayoutInflater.from(context).inflate(R.layout.vtype_items, parent, false);

    }

    @Override

    public void bindView(View view, Context context, Cursor cursor) {
        TextView setvegetative_type= (TextView) view.findViewById(R.id.vtype);

        TextView setvegetative_type_id= (TextView) view.findViewById(R.id.vid);

        String vtype = cursor.getString(cursor.getColumnIndexOrThrow("vegetative_type"));

        String vid = (cursor.getString(0));

        setvegetative_type.setText(vtype);

        setvegetative_type_id.setText(vid);

        //alternate colors in listview
        int position = cursor.getPosition();
        if(position % 2 ==0){
            view.setBackgroundColor(Color.parseColor("#A4FFD8"));
        } else{
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }

}