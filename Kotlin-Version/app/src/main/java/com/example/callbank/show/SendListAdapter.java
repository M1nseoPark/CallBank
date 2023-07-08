package com.example.callbank.show;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.callbank.AccountItem;
import com.example.callbank.AccountItemView;

import java.util.ArrayList;

public class SendListAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    public static ArrayList<SendItem> items = new ArrayList<SendItem>();

    public SendListAdapter(Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void addItem(SendItem item) {
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
        SendItemView view = null;
        if (convertView == null) {
            view = new SendItemView(mContext);
        } else {
            view = (SendItemView) convertView;
        }

        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        SendItem item = items.get(position);

        //데이터 값 표시하기
        view.setName(item.getSendName());
        view.setDate(item.getSendDate());
        view.setMoney(item.getSendMoney());
        view.setBalance(item.getSendBalance());

        return view;
    }
}
