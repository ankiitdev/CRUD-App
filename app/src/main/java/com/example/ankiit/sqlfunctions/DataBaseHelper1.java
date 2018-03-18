package com.example.ankiit.sqlfunctions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ankiit on 17-Mar-18.
 */

public class DataBaseHelper1 extends SQLiteOpenHelper {
    public static final  String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME ="Student_table";

    public static final  String COL_1 = "ID";
    public static final  String COL_2 = "NAME";
    public static final  String COL_3 = "SURNAME";
    public static final  String COL_4 = "MARKS";

    public DataBaseHelper1(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + TABLE_NAME,null);
       /* if(res!=null && res.getCount() > 0)
        {
            if (res.moveToFirst())
            {
                do {

                } while (res.moveToNext());
            }
        }*/
        return res;
    }

}

