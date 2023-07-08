package com.example.callbank.show;

import static com.example.callbank.show.AccountListView2.accountID2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.callbank.AccountDBHelper;
import com.example.callbank.AccountList;
import com.example.callbank.AccountListView;
import com.example.callbank.R;
import com.example.callbank.send.Send2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SendListView extends AppCompatActivity {

    SendList sendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_list_view);

        sendList = new SendList();
        Button btBack = (Button) findViewById(R.id.btBack);
        TextView tvBank = (TextView) findViewById(R.id.tvBank);
        TextView tvAccount = (TextView) findViewById(R.id.tvAccount);
        TextView tvBalance = (TextView) findViewById(R.id.tvBalance);

        // db start
        AccountDBHelper myDb = new AccountDBHelper(SendListView.this);
        SQLiteDatabase db = myDb.getReadableDatabase();


        String sql = "select bankName, accountNumber, balance from account_test where id='" + accountID2 + "'";
        Cursor cursor = db.rawQuery(sql, null);
        while(cursor.moveToNext()){
            tvBank.setText(cursor.getString(0));
            tvAccount.setText(cursor.getString(1));
            tvBalance.setText(Integer.toString(cursor.getInt(2)) + "원");
        }


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, sendList).commit();

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AccountListView2.class);
                startActivity(intent);
            }
        });
    }
}
