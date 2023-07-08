package com.example.callbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class AccountListAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    public static ArrayList<AccountItem> items = new ArrayList<AccountItem>();

    public AccountListAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void addItem(AccountItem item) {
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
        AccountItemView view = null;
        if (convertView == null) {
            view = new AccountItemView(mContext);
        } else {
            view = (AccountItemView) convertView;
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        AccountItem item = items.get(position);

        //데이터 값 표시하기
        view.setBank(item.getBankName());
        view.setAccount(item.getAccountNumber());

        return view;
    }
}
