package com.example.callbank.send;

import static com.example.callbank.send.Send1.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.callbank.R;

public class Send5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send5);

        EditText etAccount = (EditText) findViewById(R.id.etAccount);
        String stAccount = etAccount.getText().toString();

        if (stAccount.length() == 0) {
            Toast.makeText(getApplicationContext(), "받으실 분의 계좌번호를 입력해주세요", Toast.LENGTH_SHORT).show();
        }
        else {
            sendInfos.add(stAccount);
            Intent intent = new Intent(getApplicationContext(), Send6.class);
            startActivity(intent);
        }
    }
}