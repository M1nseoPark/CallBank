package com.example.callbank;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    static final String DATABASE_NAME = "test.db";

    // DBHelper 생성자
    public DBHelper(Context context, int version) {
        super(context, DATABASE_NAME, null, version);
    }

    // Person Table 생성
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Person(name TEXT, Phone INT, Birth INT, ID TEXT, PW TEXT)");
    }

    // Person Table Upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Person");
        onCreate(db);
    }

    // Person Table 데이터 입력
    public void insert(String name, int Phone,int Birth, String ID, String PW) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO Person VALUES('" + name + "', " + Phone + ", '" + Birth + "', " + ID + ", '" + PW  + "')");
        db.close();
    }

    // Person Table 데이터 수정
    public void Update(String name, int Phone,int Birth, String ID, String PW) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE Person SET Phone = " + Phone + ", Birth = " + Birth + ", ID = '" + ID + "', PW = '" + PW + "'" + " WHERE NAME = '" + name + "'");
        db.close();
    }

    // Person Table 데이터 삭제
    public void Delete(String name) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE Person WHERE NAME = '" + name + "'");
        db.close();
    }

    // Person Table 조회
    public String getResult() {
        // 읽기가 가능하게 DB 열기
        SQLiteDatabase db = getReadableDatabase();
        String result = "";

        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM Person", null);
        while (cursor.moveToNext()) {
            result += " 이름 : " + cursor.getString(0)
                    + ", 전화번호 : "
                    + cursor.getInt(1)
                    + ", 생일 : "
                    + cursor.getString(2)
                    + ", 아이디 : "
                    + cursor.getString(3)
                    + ", 패스워드 : "
                    + cursor.getString(4)
                    + "\n";
        }

        return result;
    }
}


//출처: https://crazykim2.tistory.com/648 [차근차근 개발일기+일상:티스토리]
