package com.example.callbank.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.R;

public class join3 extends AppCompatActivity{

    EditText protector,Pphone;
    Button noneed,back, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join3);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        //기입 항목
        protector = findViewById(R.id.protector);
        Pphone = findViewById(R.id.PPhone);


        //다음페이지
        next=findViewById(R.id.next);
        next.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(), join4.class);
            startActivity(intent);
        });
        //다음페이지
        noneed=findViewById(R.id.Noneed);
        noneed.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(), join4.class);
            startActivity(intent);
        });

    }
}