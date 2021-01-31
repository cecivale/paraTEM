package com.cloudbycloud.paratem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class ChecklistAdapter extends RecyclerView.Adapter<ChecklistAdapter.ItemViewHolder> {
    private final LinkedList<String> mCheckList;
    private LayoutInflater mInflater;

    public ChecklistAdapter(Context context, LinkedList<String> checkList) {
        mInflater = LayoutInflater.from(context);
        this.mCheckList = checkList;
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        public final TextView checklistItemView;
        final ChecklistAdapter mAdapter;

        public ItemViewHolder(@NonNull View itemView, ChecklistAdapter adapter) {
            super(itemView);
            checklistItemView = itemView.findViewById(R.id.item);
            this.mAdapter = adapter;
        }
    }

    @NonNull
    @Override
    public ChecklistAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.checklist_item,
                parent, false);
        return new ItemViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ChecklistAdapter.ItemViewHolder holder, int position) {
        String mCurrent = mCheckList.get(position);
        holder.checklistItemView .setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mCheckList.size();
    }
}
