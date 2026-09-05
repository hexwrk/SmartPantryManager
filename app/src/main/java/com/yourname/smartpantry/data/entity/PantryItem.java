package com.yourname.smartpantry.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class PantryItem {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    private String name;

    private int quantity;

    @NonNull
    private String unit;

    @NonNull
    private String expiryDate;

    public PantryItem(@NonNull String name, int quantity, @NonNull String unit, @NonNull String expiryDate) {
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expiryDate = expiryDate;
    }

    @Ignore
    public PantryItem(int id, @NonNull String name, int quantity, @NonNull String unit, @NonNull String expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.unit = unit;
        this.expiryDate = expiryDate;
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

    @NonNull
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(@NonNull String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
