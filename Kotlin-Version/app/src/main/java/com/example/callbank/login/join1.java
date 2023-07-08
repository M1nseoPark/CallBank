package com.example.callbank.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.R;

public class join1 extends AppCompatActivity{

    EditText mail,pw,pw2;
    Button back,pwcheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_join1);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        //기입 항목
        mail = findViewById(R.id.signmail);
        pw = findViewById(R.id.signPW);
        pw2 = findViewById(R.id.signPW2);


        //비밀번호 확인 버튼
        pwcheck = findViewById(R.id.next);
        pwcheck.setOnClickListener(v -> {
            if (pw.getText().toString().equals(pw2.getText().toString())) {
                pwcheck.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), join2.class);
                        startActivity(intent);
                    }
                });
            }else {
                Toast.makeText(join1.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });

                //DBHelper myDb = new DBHelper(activity_signup.this, 1);


            }
        }