package com.example.harshavardhan.listview;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by HARSHA VARDHAN on 3/9/2016.
 */
public class MyContentProvider extends ContentProvider {


    static final String NAME_OF_PROVIDER ="MyCOntentProvider";
    static final String URL = "content://" + NAME_OF_PROVIDER + "/students";
    static final Uri URI = Uri.parse(URL);


    static final String _ID = "_id";
    static  final String STUDENT_NAME ="name";
    static final String STUDENT_GRADE = "grade";


    private SQLiteDatabase sb;
    static  final String DATABASE_NAME="School";
    static  final String TABLE_NAME ="students";
    static  final int DB_VERSION = 1;
    static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "-ID INTEGER PRIMARY KEY AUTOINCREMENET," + "name TEXT NOT NULL," + "grade TEXT NOT NULL);";


public class MyHelperClass extends SQLiteOpenHelper{

    public MyHelperClass(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

    @Override
    public boolean onCreate() {
        MyHelperClass helperClass = new MyHelperClass(getContext());
        sb = helperClass.getWritableDatabase();

        return (sb == null) ? false : true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        sb.insert()
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        SQLiteQueryBuilder b = new SQLiteQueryBuilder();
        b.setTables();
        switch()
        return 0;
    }
}
