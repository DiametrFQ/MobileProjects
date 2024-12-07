package ru.mirea.khokhlov.domain.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Star {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String description;
    private String photoUrl;

    public Star(String name, String description, String photoUrl) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
