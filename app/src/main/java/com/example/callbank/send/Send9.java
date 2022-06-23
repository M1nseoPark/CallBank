package com.example.callbank.send;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.callbank.R;

public class Send9 extends AppCompatActivity {

    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send9);

        TextView tvAlias = (TextView) findViewById(R.id.tvAlias);

        animationView = findViewById(R.id.lottie);
        animationView.setAnimation("microphone_anim.json");
        animationView.loop(true);
        animationView.playAnimation();

        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sleep(5000);

                tvAlias.setText("님을\n딸로\n저장했어요");
            }
        });
    }
}