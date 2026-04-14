package com.example.myapplicationmca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "DoctorDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Doc_detail(" +
                "doc_id TEXT PRIMARY KEY," +
                "firstname TEXT," +
                "lastname TEXT," +
                "mob TEXT," +
                "addrs TEXT," +
                "city TEXT," +
                "specialization TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Doc_detail");
        onCreate(db);
    }

    // Insert Data
    public boolean insertData(String id, String fname, String lname,
                              String mob, String addr, String city, String spec) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("doc_id", id);
        cv.put("firstname", fname);
        cv.put("lastname", lname);
        cv.put("mob", mob);
        cv.put("addrs", addr);
        cv.put("city", city);
        cv.put("specialization", spec);

        long result = db.insert("Doc_detail", null, cv);

        return result != -1;
    }

    // Search Data
    public Cursor getData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Doc_detail WHERE doc_id=?", new String[]{id});
    }
}