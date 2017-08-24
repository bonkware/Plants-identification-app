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

public class FlowerColorAdapter extends CursorAdapter {

    public  FlowerColorAdapter(Context context, Cursor cursor){

        super(context, cursor);

    }
    @Override

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.fcolor_items, parent, false);

    }

    @Override

    public void bindView(View view, Context context, Cursor cursor) {
        TextView setflower_color= (TextView) view.findViewById(R.id.fcolor);

        TextView setflower_color_id= (TextView) view.findViewById(R.id.fid);

        String fcolor = cursor.getString(cursor.getColumnIndexOrThrow("flower_color"));

        String fid = (cursor.getString(0));

        setflower_color.setText(fcolor);

        setflower_color_id.setText(fid);

        //alternate colors in listview
        int position = cursor.getPosition();
        if(position % 2 ==0){
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        } else{
            view.setBackgroundColor(Color.parseColor("#A4FFD8"));
        }
    }

}

