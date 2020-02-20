package com.example.benard.lewaplantapp;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by benard on 7/31/17.
 */

public class PlantInfoAdapter extends CursorAdapter {
    private Context mcontext;

    public PlantInfoAdapter(Context context, Cursor cursor){

        super(context, cursor);

    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override

    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        mcontext=context;

        return LayoutInflater.from(context).inflate(R.layout.plantname_items, parent, false);

    }
    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override

    public void bindView(View view, Context context, Cursor cursor) {
        TextView setinfo_id= (TextView) view.findViewById(R.id.sid);

        TextView setscientific_name= (TextView) view.findViewById(R.id.sname);

        ImageView  setImage= (ImageView) view.findViewById(R.id.img);

        String scientific_name = cursor.getString(cursor.getColumnIndexOrThrow("scientific_name"));

        String sid = (cursor.getString(0));
       // Getting images by name in a listview
        String imgName = cursor.getString(cursor.getColumnIndex("image_name"));
        int image =  mcontext.getResources().getIdentifier(imgName, "drawable",mcontext.getPackageName());
        setImage.setImageResource(image);
        //plant name
        setscientific_name.setText(scientific_name);
        setinfo_id.setText(sid);

        //alternate colors in listview
        int position = cursor.getPosition();
        if(position % 2 ==0){
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        } else{
            view.setBackgroundColor(Color.parseColor("#A4FFD8"));
        }

    }

}
