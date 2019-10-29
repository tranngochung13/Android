package com.example.FinalTestQuestion4.screen.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.FinalTestQuestion4.R;
import com.example.FinalTestQuestion4.model.Item;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    public List<Item> items;

    public ItemAdapter(Runnable mainActivity, List<Item> nitems) {
        items = nitems;
    }

    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, final int position) {
        holder.tv_name_item.setText(items.get(position).getName());
        holder.tv_quantity_item.setText(items.get(position).getQuantity());
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name_item;
        TextView tv_quantity_item;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name_item = itemView.findViewById(R.id.tv_item_name);
            tv_quantity_item = itemView.findViewById(R.id.tv_item_quantity);
        }
    }
}
