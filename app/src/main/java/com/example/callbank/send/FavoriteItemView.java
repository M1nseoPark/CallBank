package com.example.callbank.send;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.callbank.R;

public class FavoriteItemView extends LinearLayout {
    TextView tvName;
    TextView tvAlias;
    TextView tvAccount;

    public FavoriteItemView(Context context){
        super(context);
        init(context);
    }

    public FavoriteItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.account_item, this, true);

        tvName = findViewById(R.id.tvName);
        tvAlias = findViewById(R.id.tvAlias);
        tvAccount = findViewById(R.id.tvAccount);
    }

    public void setName(String name){
        tvName.setText(name);
    }

    public void setAlias(String alias){
        tvAlias.setText(alias);
    }

    public void setAccount(String account){
        tvAccount.setText(account);
    }
}
