package com.example.lenovo.sqlitefinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

public class Databasehelper extends SQLiteOpenHelper {

    private  static final String Database_name="userdetails";
    private  static final String Table_name="user_details";
    private  static final String Id="Id";
    private  static final String NAME="Name";
    private  static final int VERSION=1;
    private  static final String CREATE_TABLE="CREATE TABLE "+Table_name+"("+Id+" INTEGER PRIMARY KEY,"+NAME+" VARCHAR(255) );";
    private Context context;
    private  static  final  String DROP_TABLE="DROP TABLE IF EXIST"+Table_name;
    public Databasehelper(Context context) {
        super(context, Table_name,null, VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"On create",Toast.LENGTH_LONG).show();


        }
        catch (Exception e)
        {
            Toast.makeText(context,"Not Found",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


        try {
            db.execSQL(DROP_TABLE);
            Toast.makeText(context,"On create",Toast.LENGTH_LONG).show();
            onCreate(db);

        }
        catch (Exception e)
        {
            Toast.makeText(context,"Not Found",Toast.LENGTH_LONG).show();
        }

    }
    public long savedata(String id,String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Id,id);
        contentValues.put(NAME,name);
        long rowid=   db.insert(Table_name,null,contentValues);
        return  rowid;

    }
    public Cursor showdata()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+Table_name,null);
        return cursor;

    }
    public boolean updatedata(String id,String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Id,id);
        contentValues.put(NAME,name);
        db.update(Table_name,contentValues,Id+" =? ",new String[] {id});
        return true;


    }
    public  int deletedata(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int value=db.delete(Table_name,Id+" = ?",new String[] {id});
        return value;
    }



}
