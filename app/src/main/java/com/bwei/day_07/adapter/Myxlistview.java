package com.bwei.day_07.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bwei.day_07.R;
import com.bwei.day_07.bean.UserBean;

import java.util.List;

public class Myxlistview extends BaseAdapter {
    private  List<UserBean.Data.Mydata> list;
    private Context context;

    public Myxlistview(List<UserBean.Data.Mydata> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
             viewHolder=new ViewHolder();
             convertView=View.inflate(context, R.layout.lv_item,null);
             viewHolder.name=convertView.findViewById(R.id.name);
             viewHolder.sex=convertView.findViewById(R.id.sex);
             convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
          viewHolder.name.setText(list.get(position).getTitle());
          viewHolder.name.setText(list.get(position).getUnlikeReason());
        return convertView;
    }
    class ViewHolder{
        TextView name,sex;
    }
}
