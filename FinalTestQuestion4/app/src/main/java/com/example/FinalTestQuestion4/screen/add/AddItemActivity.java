package com.example.FinalTestQuestion4.screen.add;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.FinalTestQuestion4.R;
import com.example.FinalTestQuestion4.database.AppDatabase;
import com.example.FinalTestQuestion4.model.Item;

public class AddItemActivity extends AppCompatActivity {

    AppDatabase db;
    String item_name;
    String item_quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        db = Room.databaseBuilder(getApplicationContext(),
        AppDatabase.class, "database-name").build();

        final Button btn_AddANewItem = (Button) findViewById(R.id.btn_add_item);

        btn_AddANewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem();
                finish();
            }
        });
}

    public void addItem() {
        final EditText ed_name_item =  findViewById(R.id.edt_item_name);
        final EditText ed_quantity_item =  findViewById(R.id.edt_item_quantity);

        item_name= ed_name_item.getText().toString();
        item_quantity= ed_quantity_item.getText().toString();

        if (item_name.isEmpty() || item_quantity.isEmpty()) {
            Toast.makeText(this, "Type anything", Toast.LENGTH_SHORT).show();
            return;
        }

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                Item newItem = new Item(item_name,item_quantity);
                db.itemDao().insert(newItem);
                return null;
            }
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                Toast.makeText(AddItemActivity.this, item_name + " has been added successfully", Toast.LENGTH_SHORT).show();

            }
        }.execute();
    }
}
