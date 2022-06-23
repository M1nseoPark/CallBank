package com.example.callbank.send;

import static com.example.callbank.AccountListView.accountID;
import static com.example.callbank.AccountListView.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.callbank.AccountDBHelper;
import com.example.callbank.FavoriteDBHelper;
import com.example.callbank.R;

public class Send2 extends AppCompatActivity {

    String rpwd = "";   // 실제 비밀번호
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send2);

        EditText etpwd = (EditText) findViewById(R.id.etpwd);
        Button btFinish = (Button) findViewById(R.id.btFinish);

        mediaPlayer = MediaPlayer.create(this, R.raw.send2);
        mediaPlayer.start();

        // db start
        AccountDBHelper myDb = new AccountDBHelper(Send2.this);
        SQLiteDatabase db = myDb.getReadableDatabase();
        FavoriteDBHelper myDb2 = new FavoriteDBHelper(Send2.this);
        SQLiteDatabase db2 = myDb2.getReadableDatabase();

        Log.v("test", accountID);

//        String sql = "select * from report" + LoginActivity.userId + " where trainDate='" + trainDate + "'";
        String sql = "select * from account_test where id='" + accountID + "'";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            rpwd = cursor.getString(3);
        }
        Log.v("rpwd", rpwd);

//        String sql2 = "select * from report" + LoginActivity.userId + " where trainDate='" + trainDate + "'";
        String sql2 = "select * from favorite_test";
        Cursor cursor2 = db2.rawQuery(sql2, null);

        Log.v("sendInfos", String.valueOf(sendInfos.size()));

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tpwd = etpwd.getText().toString();   // 입력한 비밀번호

                if (tpwd.length() != 4) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (tpwd.equals(rpwd)){
                        if (cursor2.getCount() != 0) {
                            Intent intent = new Intent(getApplicationContext(), FavoriteListView.class);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(getApplicationContext(), Send4.class);
                            startActivity(intent);
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "비밀번호를 잘못 입력하셨습니다", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}