package com.example.callbank;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;


public class alarm extends AppCompatActivity {
    EditText Pnumber, Pname;
    Button check;
    ///String loginId,loginPwd;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

        Pnumber = findViewById(R.id.Pnumber);
        Pname = findViewById(R.id.Pname);
        check = findViewById(R.id.check);


            //확인 버튼
        check = findViewById(R.id.check);

            //확인 버튼 클릭시, 회원가입 페이지로 이동
        check.setOnClickListener(v -> {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            });

        }

    }
