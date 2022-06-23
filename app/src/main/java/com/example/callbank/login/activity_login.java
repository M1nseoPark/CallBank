package com.example.callbank.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.MainActivity;
import com.example.callbank.R;


public class activity_login extends AppCompatActivity {

    EditText et_id, et_pwd;
    Button btn_login,sign,call;
    String loginId,loginPwd;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.editID);
        et_pwd = findViewById(R.id.ediPassword);
        btn_login = findViewById(R.id.loginbutton);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);

        loginId = sharedPreferences.getString("inputId", null);
        loginPwd = sharedPreferences.getString("inputPwd", null);

        if(loginId != null && loginPwd != null) {
            if(loginId.equals("hj") && loginPwd.equals("1234")) {
                Toast.makeText(getApplicationContext(), loginId + "님 자동로그인 입니다!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("id", loginId);
                startActivity( intent);
                finish();
            }

        }else if(loginId == null && loginPwd == null) {

            btn_login.setOnClickListener(view -> {

                if (et_id.getText().toString().equals("hj") && et_pwd.getText().toString().equals("1234")) {
                    SharedPreferences sharedPreferences1 = getSharedPreferences("sharedPreferences", Activity.MODE_PRIVATE);

                    SharedPreferences.Editor autoLogin = sharedPreferences1.edit();

                    autoLogin.putString("inputId", et_id.getText().toString());
                    autoLogin.putString("inputPwd", et_pwd.getText().toString());

                    autoLogin.apply();
                    Toast.makeText(getApplicationContext(), et_id.getText().toString()+"님 환영합니다.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            });
            //회원가입 버튼
            sign = findViewById(R.id.signin);

            //회원가입 버튼 클릭시, 회원가입 페이지로 이동
            sign.setOnClickListener(v -> {
                Intent intent = new Intent(this, join1.class);
                startActivity(intent);
            });
            //상담원 전화
            call = findViewById(R.id.call);
            call.setOnClickListener(view -> {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345"));
                //Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:12345"));
                startActivity(intent);
            });

        }

    }


}