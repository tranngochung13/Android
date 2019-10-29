package com.example.FinalTestQuestion4.screen.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.FinalTestQuestion4.R;
import com.example.FinalTestQuestion4.database.AppDatabase;
import com.example.FinalTestQuestion4.model.Item;
import com.example.FinalTestQuestion4.screen.add.AddItemActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;
    ItemAdapter itemAdapter;
    public static List<Item> items;
    RecyclerView recyclerViewShowAllItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();

        recyclerViewShowAllItem = findViewById(R.id.rclviewShowItem_id);
        recyclerViewShowAllItem.setLayoutManager(new LinearLayoutManager((this)));

       Button btn_AddItem = findViewById(R.id.btn_add_item);
       btn_AddItem.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent newScreen = new Intent(MainActivity.this, AddItemActivity.class);
               startActivity(newScreen);
           }
       });
    }

    @Override
    public void onResume() {
        super.onResume();
        getAllAndShowTask();
    }

    public void getAllAndShowTask() {
        new AsyncTask<Void, Void, List<Item>>() {
            @Override
            protected List<Item> doInBackground(Void... voids) {
               items = db.itemDao().getAll();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        itemAdapter = new ItemAdapter(this, items);
                        recyclerViewShowAllItem.setAdapter(itemAdapter);
                        Toast.makeText(MainActivity.this, "Number of confession " + items.size(), Toast.LENGTH_SHORT).show();

                    }
                });
                return null;
            }
        }.execute();
    }
}
