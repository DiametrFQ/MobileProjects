package ru.mirea.khokhlov.data.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StarDao {
    @Insert
    void insertStar(StarEntity star);

    @Query("SELECT * FROM stars")
    List<StarEntity> getAllStars();

    @Query("DELETE FROM stars")
    void deleteAllStars();
}
