package com.example.callbank.send;

import static com.example.callbank.AccountListView.sendInfos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.callbank.MainActivity;
import com.example.callbank.R;

public class Send8 extends AppCompatActivity {

    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send8);

        TextView tvCheck = (TextView) findViewById(R.id.tvCheck);
        Button btFinish = (Button) findViewById(R.id.btFinish);
        Button btMessage = (Button) findViewById(R.id.btMessage);

        animationView = findViewById(R.id.lottie);
        animationView.setAnimation("check_anim.json");
        animationView.loop(true);
        animationView.playAnimation();

        tvCheck.setText(sendInfos.get(4) + "님에게 " + sendInfos.get(5) + "원이 입금되었습니다");

        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Send9.class);
                startActivity(intent);
            }
        });
    }
}