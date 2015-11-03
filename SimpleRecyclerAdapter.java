package com.baidu.bpit.dushenghuo.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by pengwei08 on 15/11/3.
 * 通用的recyclerView适配器
 */
public abstract class SimpleRecyclerAdapter<T> extends RecyclerView.Adapter {

    private List<T> mList;

    public SimpleRecyclerAdapter(List<T> list) {
        if (list == null) {
            mList = new ArrayList<T>();
        } else {
            this.mList = list;
        }
    }

    public SimpleRecyclerAdapter(T[] array) {
        if (array != null) {
            mList = Arrays.asList(array);
        } else {
            mList = new ArrayList<T>();
        }
    }

    /**
     * 设置Item资源文件
     *
     * @return
     */
    public abstract int getLayoutRes();

    /**
     * 设置每项的值
     *
     * @param holder
     * @param position
     * @param t
     */
    public abstract void onBindView(RVHolder holder, int position, T t);


    /**
     * 每项的点击事件
     *
     * @param holder
     * @param view
     * @param position
     * @param item
     */
    public void onItemClick(RVHolder holder, View view, int position, T item) {

    }

    @Override
    public RVHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        final View content = LayoutInflater.from(parent.getContext()).inflate(getLayoutRes(), parent, false);
        return new RVHolder(content);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        onBindView((RVHolder) holder, position, mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick((RVHolder) holder, v, position, mList.get(position));
            }
        });
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    /**
     * 增加元素
     *
     * @param collection
     */
    public void addAll(Collection<T> collection) {
        mList.addAll(collection);
        notifyDataSetChanged();
    }

    /**
     * 清理
     */
    public void clear() {
        mList.clear();
    }

    /**
     * recyclerView通用的ViewHolder
     */
    public class RVHolder extends ViewHolder {

        private View itemView;

        public RVHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
        }

        public <T extends View> T get(int id) {
            SparseArray<View> viewHolder = (SparseArray<View>) itemView.getTag();
            if (viewHolder == null) {
                viewHolder = new SparseArray<View>();
                itemView.setTag(viewHolder);
            }
            View childView = viewHolder.get(id);
            if (childView == null) {
                childView = itemView.findViewById(id);
                viewHolder.put(id, childView);
            }
            return (T) childView;
        }

        public TextView getTextView(int id) {
            return get(id);
        }

        public Button getButton(int id) {
            return get(id);
        }

        public ImageView getImageView(int id) {
            return get(id);
        }

        public void setTextView(int id, CharSequence charSequence) {
            getTextView(id).setText(charSequence);
        }
    }
}


