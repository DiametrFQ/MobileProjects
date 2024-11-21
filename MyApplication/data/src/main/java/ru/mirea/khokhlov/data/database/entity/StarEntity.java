package ru.mirea.khokhlov.data.dao;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "stars")
public class StarEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String description;

    public StarEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }
}