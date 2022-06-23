package com.example.callbank.show;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.AccountList;
import com.example.callbank.AccountListView;
import com.example.callbank.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SendListView extends AppCompatActivity {

    SendList sendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_list_view);

        sendList = new SendList();
        Button btFinish = (Button) findViewById(R.id.btFinish);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, sendList).commit();

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountListView2.class);
                startActivity(intent);
            }
        });
    }
}
