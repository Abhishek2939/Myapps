package com.example.hello.airindia;

/**
 * Created by hp on 7/11/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {

    public static final String TAG = "DBHelper";

    public static final String DATABASE_NAME = "loginlist.db";
    public static final String EMP_TABLE_NAME = "userslist";
    public static final String EMP_COLUMN_ID = "id";
    public static final String EMP_COLUMN_EMAIL = "email";
    public static final String EMP_COLUMN_CONTACT = "contact";
    public static final String EMP_COLUMN_COUNTRY = "country";
    public static final String EMP_COLUMN_PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + EMP_TABLE_NAME + " (" + EMP_COLUMN_ID + " integer primary key, "
                        + EMP_COLUMN_EMAIL + " text, " + EMP_COLUMN_PASSWORD + " text ,"
                        + EMP_COLUMN_CONTACT + " text ," + EMP_COLUMN_COUNTRY + " text )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    /* Insert a row into the database */
    public boolean insert(String email, String password , String contact, String country) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password",password);
        contentValues.put("contact", contact);
        contentValues.put("country",country);
        db.insert(EMP_TABLE_NAME, null, contentValues);
        return true;
    }
    //search

    public ArrayList<users> getAllusers(String searchemail,String searchpassword) {

        ArrayList<users> employeeList = new ArrayList<users>();
        String query;

        if (searchemail == null&&searchpassword== null) {
            query = "select * from " + EMP_TABLE_NAME;
        } else{
            query = "select * from " + EMP_TABLE_NAME + " where  (email like '%"
                    + searchemail + "%') AND (password like '%" + searchpassword + "%')";
    }

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(query, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {

            users emp = new users();

            int id = res.getInt(0);
            String email = res.getString(1);
            String password = res.getString(2);
            String contact = res.getString(3);
            String country = res.getString(4);

            emp.setAll(id, email, password,contact,country);
            employeeList.add(emp);

            res.moveToNext();
        }
        return employeeList;

    }
}