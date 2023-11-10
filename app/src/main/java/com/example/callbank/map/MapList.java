package com.example.callbank.map;

import static com.example.callbank.AccountListView.accountID;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.callbank.R;
import com.example.callbank.SendDBHelper;
import com.example.callbank.show.SendItem;
import com.example.callbank.show.SendListAdapter;

import java.util.ArrayList;

public class MapList extends Fragment {

    SQLiteDatabase database;
    ListView mapList;
    MapListAdapter adapter;

    public static ArrayList<Marker> markers = new ArrayList<Marker>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.map_list, container, false);
        // 초기화, 참조 및 생성
        mapList = (ListView) view.findViewById(android.R.id.list);
        openDB();

        // 리스트뷰 참조 및 Adapter 연결
        adapter = new MapListAdapter(getActivity());

        // 맨 처음 초기화 데이터 보여주기 (select)
        if (database != null) {
            String tableName = "bank";
            String query = "select kind, name, address, tel, latitude, longitude from " + tableName;
            Cursor cursor = database.rawQuery(query, null);
            Log.v("test", "조회된 데이터 수 : " + cursor.getCount());

            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                String kind = cursor.getString(0);
                String name = cursor.getString(1);
                String address = cursor.getString(2);
                String tel = cursor.getString(3);
                double latitude = cursor.getDouble(4);
                double longitude = cursor.getDouble(5);

                adapter.addItem(new MapItem(kind, name, address, tel, latitude, longitude));
                markers.add(new Marker(kind, name, latitude, longitude));
            }
            cursor.close();
        }
        else {
            Log.e("test", "selectData() db없음.");
        }
        mapList.setAdapter(adapter);

        return view;
    }

    public void openDB() {
        Log.v("test", "openDB() 실행");
        MapDBHelper helper = new MapDBHelper(getContext());
        database = helper.getWritableDatabase();

        if (database != null) {
            Log.v("test", "DB 열기 성공!");
        } else {
            Log.e("test", "DB 열기 실패!");
        }
    }
}
