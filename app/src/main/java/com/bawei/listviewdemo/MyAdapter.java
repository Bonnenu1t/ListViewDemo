package com.bawei.listviewdemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bonnenu1t丶 on 2017/6/8.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Beans> list;
    public MyAdapter(Context context, List<Beans> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0 ;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if (convertView==null){
            holder=new viewHolder();
            convertView=View.inflate(context,R.layout.listview_item,null);
            holder.textView= (TextView) convertView.findViewById(R.id.text_view);
            holder.checkBox= (CheckBox) convertView.findViewById(R.id.check_box);
            convertView.setTag(holder);
        }else {
            holder= (viewHolder) convertView.getTag();
        }
        holder.textView.setText(list.get(position).getName());

        if(list.get(position).ischecks()){
            holder.checkBox.setChecked(true);
        } else {
            holder.checkBox.setChecked(false);
        }

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(list.get(position).ischecks()){
                    list.get(position).setIschecks(false);

                }else {
                    list.get(position).setIschecks(true);

                }
                notifyDataSetChanged();
            }

        });

        return convertView;
    }

    class viewHolder{
        TextView textView;
        CheckBox checkBox;
    }
}
