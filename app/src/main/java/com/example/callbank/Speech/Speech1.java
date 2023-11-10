package com.example.callbank.Speech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.callbank.AccountListView;
import com.example.callbank.R;

public class Speech1 extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech1);

        Button btSpeech = (Button) findViewById(R.id.btSpeech);
        Button btCall = (Button) findViewById(R.id.btCall);
        Button btBack = (Button) findViewById(R.id.btBack);

        mediaPlayer = MediaPlayer.create(this, R.raw.speech1);
        mediaPlayer.start();

        btSpeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Speech2.class);
                startActivity(intent);
            }
        });
    }
}