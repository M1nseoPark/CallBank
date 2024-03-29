package com.example.callbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FavoriteDBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Favorite.db";
    private static final int DATABASE_VERSION = 3;
    //    private static final String TABLE_NAME = "favorite" + MainActivity.userId;
    private static final String TABLE_NAME = "favorite_test";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_FNAME = "fname";
    private static final String COLUMN_FALIAS = "falias";
    private static final String COLUMN_FBANK = "fbank";
    private static final String COLUMN_FACCOUNT = "faccount";


    public FavoriteDBHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String query = "CREATE TABLE " + TABLE_NAME
                + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FNAME + " TEXT, "
                + COLUMN_FALIAS + " TEXT, "
                + COLUMN_FBANK + " TEXT, "
                + COLUMN_FACCOUNT + " TEXT); ";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(String fname, String falias, String bank, String faccount)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FNAME, fname);
        cv.put(COLUMN_FALIAS, falias);
        cv.put(COLUMN_FBANK, bank);
        cv.put(COLUMN_FACCOUNT, faccount);

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
