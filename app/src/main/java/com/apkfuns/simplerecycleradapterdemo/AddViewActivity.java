package com.apkfuns.simplerecycleradapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.apkfuns.simplerecycleradapter.RVHolder;
import com.apkfuns.simplerecycleradapter.SimpleRecyclerAdapter;

/**
 * Created by pengwei08 on 15/11/9.
 */
public class AddViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyRecyclerAdapter(new String[]{"1", "2", "3", "4"}));
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
        }
    }
}
