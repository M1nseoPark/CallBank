package com.example.callbank.map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.callbank.show.SendItem;
import com.example.callbank.show.SendItemView;

import java.util.ArrayList;

public class MapListAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    public static ArrayList<MapItem> items = new ArrayList<MapItem>();

    public MapListAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void addItem(MapItem item) {
        items.add(item);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removeItemAll(){
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MapItemView view = null;
        if (convertView == null) {
            view = new MapItemView(mContext);
        } else {
            view = (MapItemView) convertView;
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        MapItem item = items.get(position);

        //데이터 값 표시하기
        view.setKind(item.getKind());
        view.setName(item.getName());
        view.setAddress(item.getAddress());
        view.setTel(item.getTel());

        return view;
    }
}
