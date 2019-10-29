package com.example.finaltestquestion3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<User> users;

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.textViewEvenNumber.setText(""+users.get(position).evenNumber);
    }

    @Override
    public int getItemCount() {
        if (users == null){
            return 0;
        }
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textViewEvenNumber;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewEvenNumber = itemView.findViewById(R.id.evenNumber);
        }
    }
}
