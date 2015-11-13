package com.apkfuns.simplerecycleradapterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.apkfuns.simplerecycleradapter.RVHolder;
import com.apkfuns.simplerecycleradapter.SimpleRecyclerAdapter;

import java.util.List;


public class SimpleListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 构造方法一
        recyclerView.setAdapter(new SimpleRecyclerAdapter<String>() {
            @Override
            public String[] getDataArray() {
                return new String[]{"1", "2", "3", "4"};
            }

            @Override
            public int getLayoutRes() {
                return R.layout.view_text;
            }

            @Override
            public void onBindView(RVHolder holder, int position, int itemViewType, String o) {
                holder.setTextView(R.id.text, o);
            }
        });

        // 构造方法二
        recyclerView.setAdapter(new SimpleRecyclerAdapter<String>(R.layout.view_text,
                new String[]{"1", "2", "3", "4"}) {
            @Override
            public void onBindView(RVHolder holder, int position, int itemViewType, String o) {
                holder.setTextView(R.id.text, o);
            }
        });

        // 构造方法三
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(new String[]{"1", "2", "3", "4"});
        adapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView.ViewHolder holder, View view, int position, Object item) {

            }
        });
        recyclerView.setAdapter(adapter);
    }

    class MyRecyclerAdapter extends SimpleRecyclerAdapter<String> {

        public MyRecyclerAdapter(String[] array) {
            super(array);
        }

        @Override
        public int getLayoutRes() {
            return R.layout.view_text;
        }

        @Override
        public void onBindView(RVHolder holder, int position, int itemViewType, String s) {
            holder.setTextView(R.id.text, s);
            holder.itemView.setOnLongClickListener(null);
        }
    }

}
