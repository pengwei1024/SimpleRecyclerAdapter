package com.apkfuns.simplerecycleradapterdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apkfuns.simplerecycleradapter.RVHolder;
import com.apkfuns.simplerecycleradapter.SimpleRecyclerAdapter;
import com.apkfuns.simplerecycleradapterdemo.R;
import com.apkfuns.simplerecycleradapterdemo.models.DemoModel;

/**
 * Created by pengwei08 on 15/11/13.
 */
public class DemoAdapter extends SimpleRecyclerAdapter<DemoModel.Subject> {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_DEFAULT_LIST = 2;
    private static final int TYPE_FOOTER = 3;

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
            return TYPE_HEADER;
        } else if (position == getItemCount() - 1) {
            return TYPE_FOOTER;
        }
        return TYPE_DEFAULT_LIST;
    }

    @Override
    public RVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_HEADER:
                return createRVHolder(parent, R.layout.view_demo_header);
            case TYPE_FOOTER:
                TextView footView = new TextView(parent.getContext());
                footView.setText("footer");
                return createRVHolder(footView);
            default:
                return createRVHolder(parent, getLayoutRes());
        }
    }

    @Override
    public void onBindView(RVHolder holder, int position, int itemViewType, DemoModel.Subject subject) {
        if (itemViewType == TYPE_HEADER) {
            holder.setTextView(R.id.header_text, demoModel.getName());
        } else if (itemViewType == TYPE_FOOTER) {
            TextView footerView = (TextView) holder.itemView;
            footerView.setText("footer view");
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

    @Override
    public int getItemCount() {
        // list长度 + header + footer
        return super.getItemCount() + 2;
    }
}
