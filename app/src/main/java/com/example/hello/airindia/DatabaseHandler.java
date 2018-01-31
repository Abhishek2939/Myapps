package com.example.hello.airindia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseHandler extends SQLiteOpenHelper {

    public static final String TAG = "DBHelper";

    public static final String DATABASE_NAME = "Flightdatabase.db";
    public static final String EMP_TABLE_NAME = "passengerslist";
    public static final String EMP_COLUMN_ID = "id";
    public static final String EMP_COLUMN_NAME = "name";
    public static final String EMP_COLUMN_PHONE = "phonenumber";
    public static final String EMP_COLUMN_Email = "email";
    public static final String EMP_COLUMN_AMOUNT = "amount";
    public static final String EMP_COLUMN_DATE = "date";
    public static final String EMP_COLUMN_DEPLOC = "deploc";
    public static final String EMP_COLUMN_DESTLOC = "destloc";
    public static final String EMP_COLUMN_FNO = "fno";
    public static final String EMP_COLUMN_TNO = "tno";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE IF NOT EXISTS " + EMP_TABLE_NAME + " (" + EMP_COLUMN_ID + " integer primary key, "
                        + EMP_COLUMN_NAME + " text, " + EMP_COLUMN_PHONE + " text," + EMP_COLUMN_Email + " text, "
                        + EMP_COLUMN_AMOUNT + " text, " + EMP_COLUMN_DATE + " text, " + EMP_COLUMN_DEPLOC + " text, "
                        + EMP_COLUMN_DESTLOC + " text, " + EMP_COLUMN_FNO + " text, " + EMP_COLUMN_TNO + " text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String name, String phone_number, String email, String amount,
                          String Date, String deploc, String destloc, String Fno, String tno) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phonenumber", phone_number);
        contentValues.put("email", email);
        contentValues.put("amount", amount);
        contentValues.put("date", Date);
        contentValues.put("deploc", deploc);
        contentValues.put("destloc", destloc);
        contentValues.put("fno", Fno);
        contentValues.put("tno", tno);
        db.insert(EMP_TABLE_NAME, null, contentValues);
        return true;
    }
    //search

    public ArrayList<Contact> getAllContact(String searchemail, String searchflight, String searchdate) {

        ArrayList<Contact> employeeList = new ArrayList<Contact>();
        String query;

        if (searchemail == null && searchflight == null && searchdate == null) {
            query = "select * from " + EMP_TABLE_NAME;
        } else
            query = "select * from " + EMP_TABLE_NAME + "  where  (email like '%" + searchemail + "%')" +
                    " AND (fno like '%" + searchflight + "%')AND (date like '%" + searchdate + "%') ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(query, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {

            Contact emp = new Contact();

            int id = res.getInt(0);
            String name = res.getString(1);
            String phone_number = res.getString(2);
            String email = res.getString(3);
            String amount = res.getString(4);
            String date = res.getString(5);
            String deploc = res.getString(6);
            String destloc = res.getString(7);
            String fno = res.getString(8);
            String tno = res.getString(9);


            emp.setAll(id, name, phone_number, email, amount, date, deploc, destloc, fno, tno);
            employeeList.add(emp);

            res.moveToNext();
        }
        return employeeList;

    }

    public int getFirstId() {

        int idToUpdate = 0;
        String query = "select id from " + EMP_TABLE_NAME + " LIMIT 1";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery(query, null);

        if (null != res && res.getCount() > 0) {
            res.moveToFirst();
            idToUpdate = res.getInt(0);
        }
        return idToUpdate;
    }

    /* Delete the row with ID - id from the employees table */
    public Integer deleteRow(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EMP_TABLE_NAME, "email = ? ", new String[]{email});
    }

}