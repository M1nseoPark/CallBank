package com.example.callbank;

import static com.example.callbank.AccountListView.accountID;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.callbank.show.AccountListView2;

import java.util.Date;

public class AccountList extends Fragment {
    SQLiteDatabase database;
    ListView accountList;
    AccountListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.account_list, container, false);
        // 초기화, 참조 및 생성
        accountList = (ListView) view.findViewById(android.R.id.list);
        openDB();

        // 리스트뷰 참조 및 Adapter 연결
        adapter = new AccountListAdapter(getActivity());

        // 맨 처음 초기화 데이터 보여주기 (select)
        if (database != null) {
//            String tableName = "store_data";
            String tableName = "account_test";
            String query = "select id, bankName, accountNumber from " + tableName;
            Cursor cursor = database.rawQuery(query, null);
            Log.v("test", "조회된 데이터 수 : " + cursor.getCount());

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                String bankName = cursor.getString(1);
                String accountNumber = cursor.getString(2);

                adapter.addItem(new AccountItem(id, bankName, accountNumber));
            }
            cursor.close();
        }
        else {
            Log.e("test", "selectData() db없음.");
        }
        accountList.setAdapter(adapter);


        accountList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AccountItem item = (AccountItem) adapter.getItem(i);
                accountID = String.valueOf(item.getId());
                AccountListView2.accountID2 = String.valueOf(item.getId());
            }
        });

        return view;
    }

    public void openDB() {
        Log.v("test", "openDB() 실행");
        AccountDBHelper helper = new AccountDBHelper(getContext());
        database = helper.getWritableDatabase();

        if (database != null) {
            Log.v("test", "DB 열기 성공!");
        } else {
            Log.e("test", "DB 열기 실패!");
        }
    }
}
