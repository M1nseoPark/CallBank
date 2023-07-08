package com.example.callbank.send;

import static com.example.callbank.AccountListView.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.callbank.R;

public class Send5 extends AppCompatActivity {

    EditText etAccount;
    String stAccount;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send5);

        etAccount = (EditText) findViewById(R.id.etAccount);
        Button btFinish = (Button) findViewById(R.id.btFinish);
        Button btBack = (Button) findViewById(R.id.btBack);

        mediaPlayer = MediaPlayer.create(this, R.raw.send5);
        mediaPlayer.start();

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("test", stAccount);
                sendInfos.add(stAccount);

                if (stAccount.length() == 0) {
                    Toast.makeText(getApplicationContext(), "받으실 분의 계좌번호를 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (stAccount.equals("064121181983")) {
                        sendInfos.add("박민서");
                    }
                    else if (stAccount.equals("17852152058498")) {
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
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Send4.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v){
        stAccount = etAccount.getText().toString();

        switch (v.getId()) {
            case R.id.bt1:
                stAccount += "1";
                etAccount.setText(stAccount);
                break;
            case R.id.bt2:
                stAccount += "2";
                etAccount.setText(stAccount);
                break;
            case R.id.bt3:
                stAccount += "3";
                etAccount.setText(stAccount);
                break;
            case R.id.bt4:
                stAccount += "4";
                etAccount.setText(stAccount);
                break;
            case R.id.bt5:
                stAccount += "5";
                etAccount.setText(stAccount);
                break;
            case R.id.bt6:
                stAccount += "6";
                etAccount.setText(stAccount);
                break;
            case R.id.bt7:
                stAccount += "7";
                etAccount.setText(stAccount);
                break;
            case R.id.bt8:
                stAccount += "8";
                etAccount.setText(stAccount);
                break;
            case R.id.bt9:
                stAccount += "9";
                etAccount.setText(stAccount);
                break;
            case R.id.bt00:
                stAccount += "00";
                etAccount.setText(stAccount);
                break;
            case R.id.bt0:
                stAccount += "0";
                etAccount.setText(stAccount);
                break;
            case R.id.btCancel:
                etAccount.setText(stAccount.substring(0, stAccount.length()-1));
                break;
        }
    }
}