package com.example.callbank.show;

import static com.example.callbank.AccountListView.accountID;

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

import com.example.callbank.AccountDBHelper;
import com.example.callbank.AccountItem;
import com.example.callbank.AccountListAdapter;
import com.example.callbank.R;
import com.example.callbank.SendDBHelper;

public class SendList extends Fragment {
    SQLiteDatabase database;
    ListView sendList;
    SendListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.send_list, container, false);
        // 초기화, 참조 및 생성
        sendList = (ListView) view.findViewById(android.R.id.list);
        openDB();

        // 리스트뷰 참조 및 Adapter 연결
        adapter = new SendListAdapter(getActivity());

        // 맨 처음 초기화 데이터 보여주기 (select)
        if (database != null) {
//            String tableName = "store_data";
            String tableName = "send_test";
            String query = "select date, accountID, sendName, sendMoney, sendBalance from " + tableName;
            Cursor cursor = database.rawQuery(query, null);
            Log.v("test", "조회된 데이터 수 : " + cursor.getCount());

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String date = cursor.getString(0);
                int id = cursor.getInt(1);
                String sendName = cursor.getString(2);
                int sendMoney = cursor.getInt(3);
                int sendBalance = cursor.getInt(4);

                if (Integer.parseInt(accountID) == id) {
                    adapter.addItem(new SendItem(sendName, date, sendMoney, sendBalance));
                }
            }
            cursor.close();
        }
        else {
            Log.e("test", "selectData() db없음.");
        }
        sendList.setAdapter(adapter);

        return view;
    }

    public void openDB() {
        Log.v("test", "openDB() 실행");
        SendDBHelper helper = new SendDBHelper(getContext());
        database = helper.getWritableDatabase();

        if (database != null) {
            Log.v("test", "DB 열기 성공!");
        } else {
            Log.e("test", "DB 열기 실패!");
        }
    }
}
