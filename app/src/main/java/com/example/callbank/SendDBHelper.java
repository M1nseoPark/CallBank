package com.example.callbank;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.callbank.MainActivity;

public class SendDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Send.db";
    private static final int DATABASE_VERSION = 2;
//    private static final String TABLE_NAME = "send" + MainActivity.userId;
    private static final String TABLE_NAME = "send_test";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_ACCOUNT_ID = "accountID";
    private static final String COLUMN_SEND_NAME = "sendName";
    private static final String COLUMN_SEND_BANK = "sendBank";
    private static final String COLUMN_SEND_ACCOUNT = "sendAccount";
    private static final String COLUMN_SEND_MONEY = "sendMoney";
    private static final String COLUMN_SEND_BALANCE = "sendBalance";


    public SendDBHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_DATE + " TEXT, "
                + COLUMN_ACCOUNT_ID + " INTEGER, "
                + COLUMN_SEND_NAME + " TEXT, "
                + COLUMN_SEND_BANK + " TEXT, "
                + COLUMN_SEND_ACCOUNT + " TEXT, "
                + COLUMN_SEND_MONEY + " INTEGER, "
                + COLUMN_SEND_BALANCE + " INTEGER); ";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(String date, int accountID, String name, String bank, String account, int money, int balance)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_ACCOUNT_ID, accountID);
        cv.put(COLUMN_SEND_NAME, name);
        cv.put(COLUMN_SEND_BANK, bank);
        cv.put(COLUMN_SEND_ACCOUNT, account);
        cv.put(COLUMN_SEND_MONEY, money);
        cv.put(COLUMN_SEND_BALANCE, balance);

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
