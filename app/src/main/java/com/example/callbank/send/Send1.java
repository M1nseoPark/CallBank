package com.example.callbank.send;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.callbank.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Send1 extends AppCompatActivity {

    public static ArrayList<String> sendInfos = new ArrayList<String>();

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    String sendDate;
    public static String accountID;   // 선택한 계좌의 id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send1);

        // 현재 날짜 가져오기
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        sendDate = mFormat.format(mDate);

        sendInfos.add(sendDate);
        sendInfos.add(accountID);
    }
}