package com.example.callbank.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;


import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.DBHelper;
import com.example.callbank.R;


public class activity_signup extends AppCompatActivity {
    TextView back;
    EditText name, Phone, id, pw, pw2, birth;
    Button pwcheck, submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //// 회원가입 기입 부분
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        //기입 항목
        name = findViewById(R.id.signName);
        Phone = findViewById(R.id.Phone);
        id = findViewById(R.id.signID);
        pw = findViewById(R.id.signPW);
        pw2 = findViewById(R.id.signPW2);
        birth = findViewById(R.id.signBirth);


        //비밀번호 확인 버튼
        pwcheck = findViewById(R.id.pwcheckbutton);
        pwcheck.setOnClickListener(v -> {
            if (pw.getText().toString().equals(pw2.getText().toString())) {
                pwcheck.setText("일치");
            } else {
                Toast.makeText(activity_signup.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });

        DBHelper myDb = new DBHelper(activity_signup.this, 1);

        myDb.insert(name.getText().toString().trim(), Integer.parseInt(Phone.getText().toString().trim()),
                Integer.parseInt(birth.getText().toString().trim()), id.getText().toString().trim(),
                pw.getText().toString().trim());

        //영상통화 버튼
//        submit = findViewById(R.id.videocall);
//        submit.setOnClickListener(view -> {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_DIAL);
//            intent.setData(Uri.parse("tel:12345"));
//            //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
//            startActivity(intent);
//        });

//        submit = findViewById(R.id.videocall);
//        //회원가입 버튼 클릭시, 회원가입 페이지로 이동
//        submit.setOnClickListener(v -> {
//            Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
//            startActivity(intent);
//        });
//
//        }


    }
}

//자동 로그인 = https://hyejin.tistory.com/m/26, SharedPreferences
//로그인이랑 회원가입 =

        //출처: https://crazykim2.tistory.com/648 [차근차근 개발일기+일상:티스토리]