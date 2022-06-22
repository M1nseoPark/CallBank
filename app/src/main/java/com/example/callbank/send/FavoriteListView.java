package com.example.callbank.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.AccountList;
import com.example.callbank.R;

import java.util.Date;

public class FavoriteListView extends AppCompatActivity {

    FavoriteList favoriteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_list_view);

        favoriteList = new FavoriteList();
        Button btPass = (Button) findViewById(R.id.btPass);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, favoriteList).commit();

        btPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Send4.class);
                startActivity(intent);
            }
        });
    }
}
