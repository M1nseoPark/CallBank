package com.example.callbank.show;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.AccountList;
import com.example.callbank.R;
import com.example.callbank.send.Send2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccountListView2 extends AppCompatActivity {

    AccountList accountList;
    MediaPlayer mediaPlayer;

    public static String accountID2 = "";   // 선택한 계좌의 id

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list_view_2);

        accountList = new AccountList();
        Button btFinish = (Button) findViewById(R.id.btFinish);

        mediaPlayer = MediaPlayer.create(this, R.raw.show1);
        mediaPlayer.start();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, accountList).commit();

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accountID2.equals("")) {
                    Toast.makeText(getApplicationContext(), "계좌를 선택해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), SendListView.class);
                    startActivity(intent);
                }
            }
        });
    }
}
