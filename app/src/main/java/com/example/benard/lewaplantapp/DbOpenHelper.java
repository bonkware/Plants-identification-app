package com.example.benard.lewaplantapp;

/**
 * Created by benard on 7/24/17.
 * Database open and access helper
 */
import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
//class for database connection
public class DbOpenHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "lewaplantapp.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
