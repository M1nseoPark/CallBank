package com.example.callbank.send;

import static com.example.callbank.AccountListView.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.callbank.R;

public class Send6 extends AppCompatActivity {

    EditText etMoney;
    String stMoney;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send6);

        etMoney = (EditText) findViewById(R.id.etMoney);
        TextView tvInfo = (TextView) findViewById(R.id.tvInfo);

        Button btFinish = (Button) findViewById(R.id.btFinish);
        Button btBack = (Button) findViewById(R.id.btBack);

        mediaPlayer = MediaPlayer.create(this, R.raw.send6);
        mediaPlayer.start();

        tvInfo.setText(sendInfos.get(2) + "   " + sendInfos.get(3) + "   " + sendInfos.get(4));


        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stMoney.length() == 0) {
                    Toast.makeText(getApplicationContext(), "보내실 금액을 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    sendInfos.add(stMoney);
                    Intent intent = new Intent(getApplicationContext(), Send7.class);
                    startActivity(intent);
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Send5.class);
                startActivity(intent);
            }
        });
    }

    public void onClick(View v){
        stMoney = etMoney.getText().toString();

        switch (v.getId()) {
            case R.id.bt1:
                stMoney += "1";
                etMoney.setText(stMoney);
                break;
            case R.id.bt2:
                stMoney += "2";
                etMoney.setText(stMoney);
                break;
            case R.id.bt3:
                stMoney += "3";
                etMoney.setText(stMoney);
                break;
            case R.id.bt4:
                stMoney += "4";
                etMoney.setText(stMoney);
                break;
            case R.id.bt5:
                stMoney += "5";
                etMoney.setText(stMoney);
                break;
            case R.id.bt6:
                stMoney += "6";
                etMoney.setText(stMoney);
                break;
            case R.id.bt7:
                stMoney += "7";
                etMoney.setText(stMoney);
                break;
            case R.id.bt8:
                stMoney += "8";
                etMoney.setText(stMoney);
                break;
            case R.id.bt9:
                stMoney += "9";
                etMoney.setText(stMoney);
                break;
            case R.id.bt00:
                stMoney += "00";
                etMoney.setText(stMoney);
                break;
            case R.id.bt0:
                stMoney += "0";
                etMoney.setText(stMoney);
                break;
            case R.id.btCancel:
                etMoney.setText(stMoney.substring(0, stMoney.length()-1));
                break;
        }
    }
}