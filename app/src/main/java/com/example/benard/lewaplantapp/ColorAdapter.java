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

public class ColorAdapter extends CursorAdapter {

    public  ColorAdapter(Context context, Cursor cursor){

        super(context, cursor);

    }
    @Override

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.color_items, parent, false);

    }

    @Override

    public void bindView(View view, Context context, Cursor cursor) {
        TextView setcolor= (TextView) view.findViewById(R.id.color);

        TextView setflower_color_id= (TextView) view.findViewById(R.id.cid);

        String color = cursor.getString(cursor.getColumnIndexOrThrow("color"));

        String cid = (cursor.getString(0));

        setcolor.setText(color);

        setflower_color_id.setText(cid);

        //alternate colors in listview
        int position = cursor.getPosition();
        if(position % 2 ==0){
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        } else{
            view.setBackgroundColor(Color.parseColor("#A4FFD8"));
        }
    }

}

