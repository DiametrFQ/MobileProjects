package ru.mirea.khokhlov.data.dao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {StarEntity.class}, version = 1)
public abstract class StarDatabase extends RoomDatabase {
    public abstract StarDao starDao();
}