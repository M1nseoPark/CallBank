package com.example.callbank.send;

import static com.example.callbank.AccountListView.sendInfos;

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
            if (stAccount.equals("064121181983")) {
                sendInfos.add("박민서");
            }
            else if (stAccount.equals("55730104415505")) {
                sendInfos.add("김주현");
            }
            else if (stAccount.equals("1002349491520")) {
                sendInfos.add("송지혜");
            }
            else if (stAccount.equals("17610952033588")) {
                sendInfos.add("이단경");
            }
            else if (stAccount.equals("94812651211")) {
                sendInfos.add("이형일");
            }

            Intent intent = new Intent(getApplicationContext(), Send6.class);
            startActivity(intent);
        }
    }
}