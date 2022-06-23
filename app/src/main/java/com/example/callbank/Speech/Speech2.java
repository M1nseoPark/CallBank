package com.example.callbank.Speech;

import static android.os.SystemClock.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
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
import com.example.callbank.R;

import java.util.HashMap;
import java.util.Map;

public class Speech2 extends AppCompatActivity {

    LottieAnimationView animationView;
    static RequestQueue requestQueue;
    TextView tvResult;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech2);

        tvResult = (TextView) findViewById(R.id.tvResult);
        animationView = findViewById(R.id.lottie);
        animationView.setAnimation("microphone_anim.json");
        animationView.loop(true);
        animationView.playAnimation();

        mediaPlayer = MediaPlayer.create(this, R.raw.speech2);
        mediaPlayer.start();

        animationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                sleep(6000);
//                makeRequest();
            }
        });

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());  // 요청 큐 만들기
        }
    }

    public void makeRequest() {
        String url = "http://101.101.210.18/";

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