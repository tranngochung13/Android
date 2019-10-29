package com.example.FinalTestQuestion4.database;

import com.example.FinalTestQuestion4.model.Item;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}