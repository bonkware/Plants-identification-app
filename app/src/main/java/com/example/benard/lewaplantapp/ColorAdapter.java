package com.example.benard.lewaplantapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by benard on 7/27/17.
 * Color adapter
 */

public class ColorAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Cglobal> colorItems;
    private String color;


    public ColorAdapter(Activity activity, List<Cglobal> colorItems) {
        this.activity = activity;
        this.colorItems = colorItems;
    }

    @Override
    public int getCount() {
        return colorItems.size();
    }

    @Override
    public Object getItem(int color) {
        return colorItems.get(color);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.color_items, null, true);

        TextView color = (TextView) convertView.findViewById(R.id.color);
        Cglobal colors = colorItems.get(position);
        color.setText(String.valueOf(colors.getColor()));
       //alternate colors in listview34
        if(position % 2 ==0){
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        } else{
            convertView.setBackgroundColor(Color.parseColor("#A4FFD8"));
        }
       /* if(position ==0){
            convertView.setBackgroundColor(Color.parseColor("#0000ff"));
        } else if(position ==1){
            convertView.setBackgroundColor(Color.parseColor("#008000"));
        }else if(position ==2){
            convertView.setBackgroundColor(Color.parseColor("#ffa500"));
        }else if(position ==3){
            convertView.setBackgroundColor(Color.parseColor("#ffc0cb"));
        }else if(position ==4){
            convertView.setBackgroundColor(Color.parseColor("#551a8b"));
        }else if(position ==5){
            convertView.setBackgroundColor(Color.parseColor("#ff0000"));
        }else if(position ==6){
            convertView.setBackgroundColor(Color.parseColor("#ffffff"));
        }else if(position ==7){
            convertView.setBackgroundColor(Color.parseColor("#ffff00"));
        }*/

        return convertView;
    }
}
