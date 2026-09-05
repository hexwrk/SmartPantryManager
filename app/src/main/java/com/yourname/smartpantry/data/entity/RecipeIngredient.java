package com.yourname.smartpantry.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(
        entity = Recipe.class,
        parentColumns = "id",
        childColumns = "recipeId",
        onDelete = ForeignKey.CASCADE),
        indices = {@Index("recipeId")})
public class RecipeIngredient {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int recipeId;

    @NonNull
    private String name;

    private int quantity;

    @NonNull
    private String unit;

    public RecipeIngredient(int recipeId, @NonNull String name, int quantity, @NonNull String unit) {
        this.recipeId = recipeId;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    @Ignore
    public RecipeIngredient(int id, int recipeId, @NonNull String name, int quantity, @NonNull String unit) {
        this.id = id;
        this.recipeId = recipeId;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @NonNull
    public String getUnit() {
        return unit;
    }

    public void setUnit(@NonNull String unit) {
        this.unit = unit;
    }
}
