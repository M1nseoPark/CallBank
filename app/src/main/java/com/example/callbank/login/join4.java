package com.example.callbank.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.DBHelper;
import com.example.callbank.MainActivity;
import com.example.callbank.R;

public class join4 extends AppCompatActivity{

    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join4);

        //특정문자열 스타일 설정
        TextView function_text = (TextView)findViewById(R.id.joinw2); //텍스트 변수 선언

        String content = function_text.getText().toString(); //텍스트 가져옴.
        SpannableString spannableString = new SpannableString(content); //객체 생성

        String word ="전화은행";
        int start = content.indexOf(word);
        int end = start + word.length();

        //색상 지정
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#2b5d5b")), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //상대적 글씨 크기 지정
        spannableString.setSpan(new RelativeSizeSpan(1.3f), start, end, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        function_text.setText(spannableString);


        //다음페이지
        check=findViewById(R.id.check);
        check.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

    }
}