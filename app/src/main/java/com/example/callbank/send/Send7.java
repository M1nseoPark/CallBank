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
import android.widget.TextView;

import com.example.callbank.AccountDBHelper;
import com.example.callbank.R;
import com.example.callbank.SendDBHelper;

public class Send7 extends AppCompatActivity {

    int balance;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send7);

        TextView tvBank = (TextView) findViewById(R.id.tvBank);
        TextView tvAccount = (TextView) findViewById(R.id.tvAccount);
        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvMoney = (TextView) findViewById(R.id.tvMoney);
        TextView tvFee = (TextView) findViewById(R.id.tvFee);
        Button btFinish = (Button) findViewById(R.id.btFinish);
        Button btCancel = (Button) findViewById(R.id.btCancel);

        mediaPlayer = MediaPlayer.create(this, R.raw.send7);
        mediaPlayer.start();


        // db start
        SendDBHelper myDb = new SendDBHelper(Send7.this);
        AccountDBHelper myDb2 = new AccountDBHelper(Send7.this);
        SQLiteDatabase db2 = myDb2.getWritableDatabase();

        String sql = "select balance from account_test where id='" + accountID + "'";
        Cursor cursor = db2.rawQuery(sql, null);
        while(cursor.moveToNext()){
            balance = cursor.getInt(0);
        }

        // 날짜, 계좌 ID, 은행 이름, 받는 사람 계좌번호, 받는 사람 이름, 송금 금액
        tvBank.setText(sendInfos.get(2));
        tvAccount.setText(sendInfos.get(3));
        tvName.setText(sendInfos.get(4));
        tvMoney.setText(sendInfos.get(5) + "원");
        tvFee.setText("500원");


        // 확인 버튼 누르면 db에 송금 내역 추가 + 계좌 잔액 차감***
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                balance -= Integer.parseInt(sendInfos.get(5));
                myDb.addData(sendInfos.get(0), Integer.parseInt(sendInfos.get(1)), sendInfos.get(4),
                        sendInfos.get(2), sendInfos.get(3), Integer.parseInt(sendInfos.get(5)), balance);
                db2.execSQL("UPDATE account_test SET balance='" + Integer.toString(balance) + "' WHERE id='" + accountID + "';");
                Intent intent = new Intent(getApplicationContext(), Send8.class);
                startActivity(intent);
            }
        });
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Send6.class);
                startActivity(intent);
            }
        });
    }
}