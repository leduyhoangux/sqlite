package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SinhVienDaTaBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = " QUANLYSINHVIEN.db";
    private static final String TABLE_NAME = " SINHVIEN";
    private static final String ID = " ID";
    private static final String TEN = "TEN";
    private static final String NAMSINH = "TUOI";
    private static final String TRUONG = "TRUONG";
    private static final String GIOITINH = "GT";
    private static final String SOTHICH = "ST";

    public SinhVienDaTaBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqr = "CREAT TABLE IF NOT EXISTS SV(ID INTEGER KEY AUTOINCREMENT ,TEN text,NAMSINH text,TRUONG text ,GIOITINH integer , SOTHICH text)";
        db.execSQL(sqr);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public void ThemSinhVien(SinhVienModel svMoi){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TEN,svMoi.getHoTen());
        values.put(NAMSINH,svMoi.getNamSinh());
        values.put(TRUONG,svMoi.getTruong());
        values.put(GIOITINH,svMoi.getGioiTinh());
        values.put(SOTHICH,svMoi.getSoThich());

        database.insert(TABLE_NAME , null,values);
        database.close();


    }
}
