package com.apkfuns.simplerecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pengwei08 on 15/11/9.
 */
public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter {

    @Override
    public final int getItemViewType(int position) {
        return getItemViewLayoutId(position);
    }

    public abstract int getItemViewLayoutId(int position);

    @Override
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RVHolder(container);
    }

    public abstract void onBindView(RVHolder holder, int position);

    @Override
    public final void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindView((RVHolder) holder, position);
    }

    @Override
    public abstract int getItemCount();
}
