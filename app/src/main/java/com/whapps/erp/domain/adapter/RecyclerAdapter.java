package com.whapps.erp.domain.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.whapps.erp.R;
import com.whapps.erp.domain.model.Timeline;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Timeline> mArrayList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;

        private ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.textView2);
        }
    }

    public RecyclerAdapter(ArrayList<Timeline> arrayList) {
        mArrayList = arrayList;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_timeline, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.title.setText(mArrayList.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}