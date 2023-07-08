package com.example.callbank.Speech;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.callbank.AccountListView;
import com.example.callbank.R;

import java.util.HashMap;
import java.util.Map;

public class Speech2 extends AppCompatActivity {

    LottieAnimationView animationView;
    static RequestQueue requestQueue;
    TextView tvResult;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech2);

        tvResult = (TextView) findViewById(R.id.tvResult);
        TextView tvAsk = (TextView) findViewById(R.id.tvAsk);

        animationView = findViewById(R.id.lottie);
        animationView.setAnimation("microphone_anim.json");
        animationView.loop(true);
        animationView.playAnimation();

        mediaPlayer = MediaPlayer.create(this, R.raw.speech2);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.speech3);
        mediaPlayer.start();

        //                makeRequest();

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                tvResult.setText("아들 만원");
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        tvAsk.setText("송금 화면으로\n이동할게요");
                        mediaPlayer2.start();
                        new Handler().postDelayed(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                Intent intent = new Intent(getApplicationContext(), AccountListView.class);
                                startActivity(intent);
                            }
                        }, 3000);
                    }
                }, 3000);
            }
        }, 7000);

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());  // 요청 큐 만들기
        }
    }

    public void makeRequest() {
        String url = "http://127.0.0.1/";

//      요청 객체 만들기 (요청방식, 웹사이트 주소, 응답받을 리스너 객체, 에러 발생시 호출될 리스너 객체)
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.v("응답-> ", response);

                        pressResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("에러-> ", error.getMessage());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };
        request.setShouldCache(false);   // 이전 응답 결과를 사용하지 않겠다면
        requestQueue.add(request);   // 요청 객체를 큐에 넣어줌
        Log.v("requestQueue", "요청 보냄");
    }

    public void pressResponse(String response) {
        tvResult.setText(response.toString());
    }
}