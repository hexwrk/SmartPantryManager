package com.yourname.smartpantry.data.dao;

import androidx.room.Insert;
import androidx.room.Query;

import com.yourname.smartpantry.data.entity.Recipe;
import com.yourname.smartpantry.data.entity.RecipeIngredient;

import java.util.List;

@androidx.room.Dao
public interface RecipeDao {

    @Insert
    long insertRecipe(Recipe recipe);

    @Insert
    void insertIngredient(RecipeIngredient ingredient);

    @Query("SELECT * FROM Recipe")
    List<Recipe> getAllRecipes();

    @Query("SELECT * FROM RecipeIngredient WHERE recipeId = :id")
    List<RecipeIngredient> getIngredientsFor(int id);
}
