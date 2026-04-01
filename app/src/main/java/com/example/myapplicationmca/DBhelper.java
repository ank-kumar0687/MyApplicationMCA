package com.example.myapplicationmca;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    public DBhelper(Context context) {
        super(context, "MyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }


    public void insertData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO users(name) VALUES('" + name + "')");
    }


    public String getData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users", null);

        String result = "No Data";
        if (cursor.moveToLast()) {
            result = cursor.getString(1); // name column
        }
        cursor.close();
        return result;
    }
}