package com.example.finaltestquestion3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.recycle_user);
        recyclerViewUser.setLayoutManager(new LinearLayoutManager(this));
        final UserAdapter userAdapter = new UserAdapter();
        recyclerViewUser.setAdapter(userAdapter);

        final List<User> users = new ArrayList<User>();
            for (int i = 0; i <= 200; i++) {
                if (i % 2 == 0){
                    users.add(new User(i));
                }
            }
        userAdapter.users = users;
        userAdapter.notifyDataSetChanged();
    }
}
