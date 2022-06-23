package com.example.callbank.show;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.callbank.R;

public class SendItemView extends LinearLayout {

    TextView tvName;
    TextView tvMoney;
    TextView tvDate;
    TextView tvBalance;

    public SendItemView(Context context){
        super(context);
        init(context);
    }

    public SendItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.send_item, this, true);

        tvName = findViewById(R.id.tvName);
        tvMoney = findViewById(R.id.tvMoney);
        tvDate = findViewById(R.id.tvDate);
        tvBalance = findViewById(R.id.tvBalance);
    }

    public void setName(String name){
        tvName.setText(name);
    }

    public void setMoney(int money){
        tvMoney.setText(Integer.toString(money));
    }

    public void setDate(String date){
        tvDate.setText(date);
    }

    public void setBalance(int balance){
        tvBalance.setText(Integer.toString(balance));
    }
}
