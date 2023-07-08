package com.example.callbank.send;

import static com.example.callbank.AccountListView.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.callbank.AccountListView;
import com.example.callbank.R;

public class Send4 extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send4);

        Button btnacf = (Button) findViewById(R.id.btnacf);
        Button kb = (Button) findViewById(R.id.kb);

        mediaPlayer = MediaPlayer.create(this, R.raw.send4);
        mediaPlayer.start();

        btnacf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendInfos.add("농협");

                Intent intent = new Intent(getApplicationContext(), Send5.class);
                startActivity(intent);
            }
        });
        kb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendInfos.add("국민은행");

                Intent intent = new Intent(getApplicationContext(), Send5.class);
                startActivity(intent);
            }
        });
    }
}