package com.bawei.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;

    private List<Beans> list=new ArrayList<Beans>();
    private MyAdapter adapter;
    boolean checked ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);

        getData();

        adapter = new MyAdapter(this, list);
        listView.setAdapter(adapter);

        findViewById(R.id.btn_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for(int i=0;i<list.size();i++){
                    if(!checked){
                        list.get(i).setIschecks(true);
                    }else {
                        list.get(i).setIschecks(false);
                    }
                }
                adapter.notifyDataSetChanged();

                if(!checked){
                    checked = true;
                }else {
                    checked = false;
                }

            }
        });
        // 点击加载更多
//         自动加载  自动分页
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                for (int i = 50; i < 100; i++) {
                    Beans beans = new Beans();
                    beans.setName(i + "哈哈");
                    list.add(beans);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

    }
            public void getData() {
                for (int i = 0; i < 50; i++) {
                    Beans beans = new Beans();
                    beans.setName(i + "哈哈");
                    list.add(beans);
                }


            }

    }

