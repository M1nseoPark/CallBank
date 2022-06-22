package com.example.callbank.send;

import static com.example.callbank.send.Send1.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.callbank.R;

public class Send4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send4);

        Button btnacf = (Button) findViewById(R.id.btnacf);

        btnacf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendInfos.add("농협");
            }
        });
    }
}