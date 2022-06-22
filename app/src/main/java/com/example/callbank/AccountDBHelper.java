package com.example.callbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class AccountDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Account.db";
    private static final int DATABASE_VERSION = 1;
    //    private static final String TABLE_NAME = "account" + MainActivity.userId;
    private static final String TABLE_NAME = "account_test";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_BANK_NAME = "bankName";
    private static final String COLUMN_ACCOUNT_NUMBER = "accountNumber";
    private static final String COLUMN_PASSWORD = "password";


    public AccountDBHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_BANK_NAME + " TEXT, "
                + COLUMN_ACCOUNT_NUMBER + " TEXT, "
                + COLUMN_PASSWORD + " TEXT); ";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(String bankName, String accountNumber, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BANK_NAME, bankName);
        cv.put(COLUMN_ACCOUNT_NUMBER, accountNumber);
        cv.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "데이터 추가 성공", Toast.LENGTH_SHORT).show();
        }
    }

}