package com.example.callbank.send;

import static com.example.callbank.AccountListView.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.callbank.R;

public class Send6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send6);

        EditText etMoney = (EditText) findViewById(R.id.etMoney);
        Button btFinish = (Button) findViewById(R.id.btFinish);
        Button btBack = (Button) findViewById(R.id.btBack);

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stMoney = etMoney.getText().toString();

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
    }
}