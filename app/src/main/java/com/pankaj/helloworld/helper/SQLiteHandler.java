package com.pankaj.helloworld.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by pankaj on 23-04-2017.
 */

public class SQLiteHandler extends SQLiteOpenHelper {
    private static final String TAG = SQLiteHandler.class.getSimpleName();

    private static ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "android_ap";

    // Login table name
    private static final String TABLE_USER = "User";

    // Login Table Columns names
    private static final String KEY_NAME = "UserName";
    private static final String KEY_EMAIL = "UserEmail";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT UNIQUE" + ")";
        db.execSQL(CREATE_TABLE);

        Log.d(TAG, "Database tables created");
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);
    }

    /**
     * Storing user details in database
     * */
    public boolean addUser(String nname, String eemail) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, nname); // Name
        values.put(KEY_EMAIL, eemail); // Email
        //values.put(KEY_UID, uid); // Email
        //values.put(KEY_CREATED_AT, created_at); // Created At

        // Inserting Row
        //long id = db.insert(TABLE_USER, null, values);

        if(db.insert(TABLE_USER, null, values) < 1){
            Log.d(TAG, "User not inserted! Please check!");
            db.close(); // Closing database connection
            return false;
        }
        else{
            Log.d(TAG, "User added to the database!");
            db.close(); // Closing database connection
            return true;
        }



    }

    public boolean updateUser(String nname, String eemail){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues updatedValues = new ContentValues();
        updatedValues.put(KEY_NAME, nname);
        updatedValues.put(KEY_EMAIL, eemail);
        String where = KEY_NAME + "='" + nname + "'";
        String whereArgs[] = null;
        // Update the row with the specified index with the new values.

        if(db.update(TABLE_USER, updatedValues, where, whereArgs) < 1){
            Log.d(TAG, "Please see if the user even exists!");
            db.close();
            return false;
        }
        else{
            Log.d(TAG, "Row updated succesfully!");
            db.close();
            return true;
        }

    }


    public boolean deleteUser(String nname){
        SQLiteDatabase db = this.getWritableDatabase();
        String where = KEY_NAME + "='" + nname + "'";

        if(db.delete(TABLE_USER, where, null) < 1){
            Log.d(TAG, "User does'nt exist.");
            db.close();
            return false;
        }
        else{
            Log.d(TAG, "User deleted Successfully1");
            db.close();
            return true;
        }
    }

    /**
     * Getting user data from database
     * */
    public ArrayList<HashMap<String, String>> getUserDetails() {
        HashMap<String, String> user = new HashMap<>();
        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        list.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        //cursor.moveToFirst();
        /*if (cursor.getCount() > 0) {
            user.put("name", cursor.getString(0));
            user.put("email", cursor.getString(1));
        }*/

        while(cursor.moveToNext()){
            user = new HashMap<String,String>();
            //Log.d("Debug", cursor.getString(2));
            user.put(KEY_EMAIL, cursor.getString(1));
            user.put(KEY_NAME, cursor.getString(0));
            list.add(user);
        }
        cursor.close();
        db.close();
        // return user
        Log.d(TAG, "Fetching user from Sqlite: " + list.toString());

        return list;
    }

    /**
     * Re crate database Delete all tables and create them again
     * */
    public boolean deleteUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Delete All Rows

        if(db.delete(TABLE_USER, null, null) < 1){
            Log.d(TAG, "Table does not exist!");
            db.close();
            return false;
        }
        else{
            Log.d(TAG, "Table dropped successfully!");
            db.close();
            return true;
        }
    }

}

