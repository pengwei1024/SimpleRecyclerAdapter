package com.apkfuns.simplerecycleradapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.simplerecycleradapter.RVHolder;
import com.apkfuns.simplerecycleradapter.SimpleRecyclerAdapter;

/**
 * Created by pengwei08 on 15/11/9.
 */
public class MultipleListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MultipleAdapter());
    }

    class MultipleAdapter extends SimpleRecyclerAdapter {

        @Override
        public int getItemViewType(int position) {
            if (position == 0 || position == getItemCount() - 1) {
                return R.layout.adapter_multiple_2;
            }
            return R.layout.adapter_multiple_1;
        }

        @Override
        public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return createRVHolder(parent, viewType);
        }

        @Override
        public void onBindView(RVHolder holder, int position, int itemViewType, Object o) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }

        @Override
        public void onItemClick(RVHolder holder, View view, int position, Object item) {
            super.onItemClick(holder, view, position, item);
        }
    }

}
