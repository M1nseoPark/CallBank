package com.example.callbank.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


        //다음페이지
        check=findViewById(R.id.check);
        check.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

    }
}