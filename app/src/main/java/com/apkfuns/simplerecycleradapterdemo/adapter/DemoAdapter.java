package com.apkfuns.simplerecycleradapterdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.apkfuns.simplerecycleradapter.RVHolder;
import com.apkfuns.simplerecycleradapter.SimpleRecyclerAdapter;
import com.apkfuns.simplerecycleradapterdemo.R;
import com.apkfuns.simplerecycleradapterdemo.models.DemoModel;

/**
 * Created by pengwei08 on 15/11/13.
 */
public class DemoAdapter extends SimpleRecyclerAdapter<DemoModel.Subject> {

    private DemoModel demoModel;

    public DemoAdapter(DemoModel demoModel) {
        super(demoModel.getList());
        this.demoModel = demoModel;
    }

    // 列表用的布局
    @Override
    public int getLayoutRes() {
        return R.layout.view_text;
    }

    // 数据类型
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return R.layout.view_demo_header;
        }
        return getLayoutRes();
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return createRVHolder(parent, viewType);
    }

    @Override
    public void onBindView(RVHolder holder, int position, DemoModel.Subject subject) {
        if (position == 0) {
            holder.setTextView(R.id.header_text, demoModel.getName());
        } else {
            holder.setTextView(R.id.text, subject.subjectName + subject.score);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 这里处理item的事件
                }
            });
        }
    }
}
