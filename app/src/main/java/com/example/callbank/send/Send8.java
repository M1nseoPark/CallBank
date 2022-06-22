package com.example.callbank.send;

import static com.example.callbank.AccountListView.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.callbank.MainActivity;
import com.example.callbank.R;

public class Send8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send8);

        TextView tvCheck = (TextView) findViewById(R.id.tvCheck);
        Button btFinish = (Button) findViewById(R.id.btFinish);
        Button btMessage = (Button) findViewById(R.id.btMessage);

        tvCheck.setText(sendInfos.get(4) + "님에게 " + sendInfos.get(5) + "원이 입금되었습니다");

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}