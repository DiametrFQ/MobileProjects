package ru.mirea.khokhlov.myapplication.domains.models;

public class Star {
    private int id;
    private String name;
    public Star(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
