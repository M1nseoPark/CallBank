package com.example.callbank.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.callbank.R;

public class MapItemView extends LinearLayout {

    TextView tvKind;
    TextView tvName;
    TextView tvAddress;
    TextView tvTel;

    public MapItemView(Context context){
        super(context);
        init(context);
    }

    public MapItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.map_item, this, true);

        tvKind = findViewById(R.id.tvKind);
        tvName = findViewById(R.id.tvName);
        tvAddress = findViewById(R.id.tvAddress);
        tvTel = findViewById(R.id.tvTel);
    }

    public void setKind(String kind){
        tvKind.setText(kind);
    }

    public void setName(String name){
        tvName.setText(name + "지점");
    }

    public void setAddress(String address){
        tvAddress.setText(address);
    }

    public void setTel(String tel){
        tvTel.setText(tel);
    }
}
