package com.example.callbank.send;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.callbank.AccountItem;
import com.example.callbank.AccountItemView;

import java.util.ArrayList;

public class FavoriteListAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    public static ArrayList<FavoriteItem> items = new ArrayList<FavoriteItem>();

    public FavoriteListAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void addItem(FavoriteItem item) {
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
        FavoriteItemView view = null;
        if (convertView == null) {
            view = new FavoriteItemView(mContext);
        } else {
            view = (FavoriteItemView) convertView;
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        FavoriteItem item = items.get(position);

        //데이터 값 표시하기
        view.setName(item.getfName());
        view.setAlias(item.getfAlias());
        view.setAccount(item.getfAccount());

        return view;
    }
}
