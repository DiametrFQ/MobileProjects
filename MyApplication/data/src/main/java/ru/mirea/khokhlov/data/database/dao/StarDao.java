package ru.mirea.khokhlov.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.mirea.khokhlov.data.database.entity.StarEntity;

@Dao
public interface StarDao {
    @Insert
    void insertAll(List<StarEntity> stars);

    @Query("SELECT * FROM StarEntity")
    List<StarEntity> getAllStars();
}
