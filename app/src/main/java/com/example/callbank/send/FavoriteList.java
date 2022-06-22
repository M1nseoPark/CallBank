package com.example.callbank.send;

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

import com.example.callbank.AccountDBHelper;
import com.example.callbank.AccountItem;
import com.example.callbank.AccountListAdapter;
import com.example.callbank.R;

public class FavoriteList extends Fragment {

    SQLiteDatabase database;
    ListView favoriteList;
    FavoriteListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.favorite_list, container, false);
        // 초기화, 참조 및 생성
        favoriteList = (ListView) view.findViewById(android.R.id.list);
        openDB();

        // 리스트뷰 참조 및 Adapter 연결
        adapter = new FavoriteListAdapter(getActivity());

        // 맨 처음 초기화 데이터 보여주기 (select)
        if (database != null) {
//            String tableName = "store_data";
            String tableName = "favorite_test";
            String query = "select * from " + tableName;
            Cursor cursor = database.rawQuery(query, null);
            Log.v("test", "조회된 데이터 수 : " + cursor.getCount());

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                int id = cursor.getInt(0);
                String fname = cursor.getString(1);
                String falias = cursor.getString(2);
                String faccount = cursor.getString(3);

                adapter.addItem(new FavoriteItem(id, fname, falias, faccount));
            }
            cursor.close();
        }
        else {
            Log.e("test", "selectData() db없음.");
        }
        favoriteList.setAdapter(adapter);


        favoriteList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), Send6.class);
                startActivity(intent);
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
