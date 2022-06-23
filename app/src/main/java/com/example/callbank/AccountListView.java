package com.example.callbank;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.send.Send2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccountListView extends AppCompatActivity {

    public static ArrayList<String> sendInfos = new ArrayList<String>();
    AccountList accountList;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    String sendDate;
    public static String accountID = "";   // 선택한 계좌의 id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list_view);

        accountList = new AccountList();
        Button btFinish = (Button) findViewById(R.id.btFinish);

        // 현재 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        sendDate = mFormat.format(mDate);

        sendInfos.add(sendDate);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, accountList).commit();

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accountID.equals("")) {
                    Toast.makeText(getApplicationContext(), "계좌를 선택해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    sendInfos.add(accountID);
                    Intent intent = new Intent(getApplicationContext(), Send2.class);
                    startActivity(intent);
                }
            }
        });
    }
}
