package com.example.callbank;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class AccountItemView extends LinearLayout {
    TextView tvBank;
    TextView tvAccount;

    public AccountItemView(Context context){
        super(context);
        init(context);
    }

    public AccountItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.account_item, this, true);

        tvBank = findViewById(R.id.tvBank);
        tvAccount = findViewById(R.id.tvAccount);
    }

    public void setBank(String bank){
        tvBank.setText(bank);
    }

    public void setAccount(String account){
        tvAccount.setText(account);
    }
}
