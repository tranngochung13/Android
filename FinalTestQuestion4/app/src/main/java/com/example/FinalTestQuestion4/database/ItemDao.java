package com.example.FinalTestQuestion4.database;

import com.example.FinalTestQuestion4.model.Item;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ItemDao {
   @Query("SELECT * FROM Item")
    List<Item> getAll();

    @Insert
    void insert(Item item);
}