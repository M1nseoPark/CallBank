package com.example.callbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.amitshekhar.DebugDB;
import com.example.callbank.Speech.Speech1;
import com.example.callbank.map.Map1;
import com.example.callbank.show.AccountListView2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivSpeech = (ImageView) findViewById(R.id.ivSpeech);
        Button sendButton = (Button) findViewById(R.id.btSend);
        Button showButton = (Button) findViewById(R.id.btShow);
        Button mapButton = (Button) findViewById(R.id.btMap);

        DebugDB.getAddressLog();

        // test data - 사용자 계좌
//        AccountDBHelper myDb = new AccountDBHelper(MainActivity.this);
//        myDb.addData("광주", "064121181983", "0000", 500000);
//        myDb.addData("카카오뱅크", "3333131111111", "1111", 700000);
//        myDb.close();

//          즐겨찾기 목록
//        FavoriteDBHelper myDb = new FavoriteDBHelper(MainActivity.this);
//        myDb.addData("박민서", "손녀", "광주", "064121181983");
//        myDb.addData("송지혜", null, "우리", "1002349491520");
//        myDb.close();

        ivSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Speech1.class);
                startActivity(intent);
            }
        });

        // 송금 화면으로 이동
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountListView.class);
                startActivity(intent);
            }
        });

        // 조회 화면으로 이동
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountListView2.class);
                startActivity(intent);
            }
        });

        // 지도 화면으로 이동
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map1.class);
                startActivity(intent);
            }
        });
    }
}