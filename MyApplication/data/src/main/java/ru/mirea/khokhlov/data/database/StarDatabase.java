package ru.mirea.khokhlov.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import ru.mirea.khokhlov.data.database.dao.StarDao;
import ru.mirea.khokhlov.data.database.entity.StarEntity;

@Database(entities = {StarEntity.class}, version = 2)
public abstract class StarDatabase extends RoomDatabase {

    private static volatile StarDatabase INSTANCE;

    public abstract StarDao starDao();

    public static StarDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (StarDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    StarDatabase.class, "star_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
