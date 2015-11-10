package com.apkfuns.simplerecycleradapter;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pengwei08 on 15/11/9.
 * recyclerView通用的ViewHolder
 */
public class RVHolder extends RecyclerView.ViewHolder {

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

    public RVHolder setTextView(int id, CharSequence charSequence) {
        getTextView(id).setText(charSequence);
        return this;
    }
}
