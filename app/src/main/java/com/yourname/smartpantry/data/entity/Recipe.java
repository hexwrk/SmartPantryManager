package com.yourname.smartpantry.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private String steps;

    public Recipe(@NonNull String name, @NonNull String steps) {
        this.name = name;
        this.steps = steps;
    }

    @Ignore
    public Recipe(int id, @NonNull String name, @NonNull String steps) {
        this.id = id;
        this.name = name;
        this.steps = steps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getSteps() {
        return steps;
    }

    public void setSteps(@NonNull String steps) {
        this.steps = steps;
    }
}
