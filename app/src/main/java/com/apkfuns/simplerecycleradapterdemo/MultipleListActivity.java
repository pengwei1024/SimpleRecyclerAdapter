package com.apkfuns.simplerecycleradapterdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.simplerecycleradapter.BaseRecyclerAdapter;
import com.apkfuns.simplerecycleradapter.RVHolder;

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

    class MultipleAdapter extends BaseRecyclerAdapter {
        @Override
        public int getItemViewLayoutId(int position) {
            if (position == 0 || position == getItemCount() - 1) {
                return R.layout.adapter_multiple_2;
            }
            return R.layout.adapter_multiple_1;
        }

        public View getItemView(LayoutInflater inflater, ViewGroup group, int position) {
            return null;
        }

        @Override
        public void onBindView(RVHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }

}
