package com.example.benard.lewaplantapp;

/**
 * Created by benard on 7/24/17.
 * Database handler class
 */

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DbHandler {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DbHandler instance;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     * @param context
     */
    public DbHandler(Context context) {
        this.openHelper = new DbOpenHelper(context);
    }

    /**
     * Return a singleton instance of DbHandler.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DbHandler getInstance(Context context) {
        if (instance == null) {
            instance = new DbHandler(context);
        }
        return instance;
    }

    /**
     * Opening the database connection.
     **/
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }
    //Get list of all colors
    public Cursor getColors() {
        String selectQuery = "SELECT * FROM colors order by id";
        return database.rawQuery(selectQuery, null);
    }
    //Get all flower colors related to the color you selected from above
    public Cursor getFlower_colors() {
        Cglobal cg = Cglobal.getInstance();
        String selectQuery = "SELECT  flower_color_id as _id, flower_color FROM flower_colors where color_id='" + cg.getId() + "'";
        return database.rawQuery(selectQuery, null);
    }
     //Get vegetative type of every color selected
    public Cursor getvtype() {
        Cglobal cg = Cglobal.getInstance();
        String selectQuery = "select vegetative_type_id as _id, vegetative_type from " +
                "plant_details join vegetative_types on vegetative_types.id=plant_details.vegetative_type_id " +
                "where plant_details.flower_color_id='" + cg.getflower_color_id() + "' group by vegetative_type;";
        return database.rawQuery(selectQuery, null);
    }
     // Getting information about the plant
    public Cursor getInfo() {
        Cglobal cg = Cglobal.getInstance();
        String selectQuery = "SELECT id as _id, image_name, scientific_name FROM plant_details where " +
                "vegetative_type_id='" + cg.getvegetative_type_id() + "' and flower_color_id='" + cg.getflower_color_id() + "'";
        return database.rawQuery(selectQuery, null);
    }
    //Getting information about the plant name from above
    public Cursor getplantInfo() {
        Cglobal cg = Cglobal.getInstance();
        String selectQuery = "SELECT distinct family, description, common_name, uses, ecology, vegetation_type, distribution, abundance,image_name FROM plant_details where " +
                "vegetative_type_id='" + cg.getvegetative_type_id() + "' and flower_color_id='" + cg.getflower_color_id() + "'and scientific_name='" + cg.getscintific_name() + "'";
        return database.rawQuery(selectQuery, null);
    }

}