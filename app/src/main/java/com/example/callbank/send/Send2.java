package com.example.callbank.send;

import static com.example.callbank.send.Send1.accountID;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.callbank.AccountDBHelper;
import com.example.callbank.R;

public class Send2 extends AppCompatActivity {

    String rpwd = "";   // 실제 비밀번호

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send2);

        EditText etpwd = (EditText) findViewById(R.id.etpwd);
        Button btFinish = (Button) findViewById(R.id.btFinish);

        String tpwd = etpwd.getText().toString();   // 입력한 비밀번호

        // db start
        AccountDBHelper myDb = new AccountDBHelper(Send2.this);
        SQLiteDatabase db = myDb.getReadableDatabase();

//        String sql = "select * from report" + LoginActivity.userId + " where trainDate='" + trainDate + "'";
        String sql = "select * from account_test where id='" + accountID + "'";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            rpwd = cursor.getString(3);
        }


        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tpwd.length() != 4) {
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else if (!tpwd.equals(rpwd)){
                    Toast.makeText(getApplicationContext(), "비밀번호를 잘못 입력하셨습니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Send3.class);
                    startActivity(intent);
                }
            }
        });
    }
}