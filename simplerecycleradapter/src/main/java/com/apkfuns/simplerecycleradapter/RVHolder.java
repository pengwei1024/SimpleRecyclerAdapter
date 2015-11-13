package com.apkfuns.simplerecycleradapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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

    public View itemView;

    public RVHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public Context getContext() {
        return itemView.getContext();
    }

    public <T extends View> T getView(int id) {
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

    public Resources getResources(){
        return getContext().getResources();
    }

    public String getString(int stringId) {
        return getResources().getString(stringId);
    }

    public TextView getTextView(int id) {
        return getView(id);
    }

    public Button getButton(int id) {
        return getView(id);
    }

    public ImageView getImageView(int id) {
        return getView(id);
    }

    public RVHolder setTextView(int id, CharSequence charSequence) {
        getTextView(id).setText(charSequence);
        return this;
    }

    public void startActivity(Class<? extends Activity> cla) {
        startActivity(cla, null);
    }

    public void startActivity(Class<? extends Activity> cla, Bundle bundle) {
        Intent it = new Intent(getContext(), cla);
        if (bundle != null) {
            it.putExtras(bundle);
        }
        getContext().startActivity(it);
    }
}
