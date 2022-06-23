package com.example.callbank.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.MainActivity;
import com.example.callbank.R;

public class MapListView extends AppCompatActivity {

    MapList mapList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_list_view);

        mapList = new MapList();
        Button btBack = (Button) findViewById(R.id.btBack);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mapList).commit();


        Button mapbutton = (Button) findViewById(R.id.mapbutton);
        Button listbutton = (Button) findViewById(R.id.listbutton);

        listbutton.setSelected(true);

        mapbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapbutton.setSelected(true);
                listbutton.setSelected(false);

                Intent intent = new Intent(getApplicationContext(), Map1.class);
                startActivity(intent);
            }
        });

        listbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapbutton.setSelected(false);
                listbutton.setSelected(true);

                Intent intent = new Intent(getApplicationContext(), MapListView.class);
                startActivity(intent);
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
