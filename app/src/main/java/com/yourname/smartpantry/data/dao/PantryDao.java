package com.yourname.smartpantry.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.yourname.smartpantry.data.entity.PantryItem;

import java.util.List;

@androidx.room.Dao
public interface PantryDao {

    @Insert
    long insert(PantryItem item);

    @Update
    void update(PantryItem item);

    @Delete
    void delete(PantryItem item);

    @Query("SELECT * FROM PantryItem")
    LiveData<List<PantryItem>> observeAll();
}
