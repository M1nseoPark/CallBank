package com.example.callbank.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.DBHelper;
import com.example.callbank.R;

public class join2 extends AppCompatActivity{

    EditText name,phone,birth;
    Button back,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join2);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        //기입 항목
        name = findViewById(R.id.name);
        phone = findViewById(R.id.Pnumber);
        birth = findViewById(R.id.birth);

        //다음페이지
        next=findViewById(R.id.next);
        next.setOnClickListener(v ->{
                Intent intent = new Intent(getApplicationContext(), join3.class);
                startActivity(intent);
        });

    }
}